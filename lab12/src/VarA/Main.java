package VarA;

import java.util.concurrent.*;
import java.util.*;
//Муминов Рустам Б762-2 ВАРИНАТ 6
public class CashRegister {
    private final Queue<String> queue = new LinkedList<>();
    private final int maxQueueSize;

    public CashRegister(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    // Попытка стать в очередь, если есть место
    public boolean joinQueue(String customer) {
        synchronized (queue) {
            if (queue.size() < maxQueueSize) {
                queue.offer(customer);
                return true;
            }
            return false;
        }
    }

    // Обслуживание клиента (удаление из очереди)
    public void serveCustomer() {
        synchronized (queue) {
            if (!queue.isEmpty()) {
                String customer = queue.poll();
                System.out.println("Обслуживаем клиента: " + customer);
            }
        }
    }

    // Получение текущей длины очереди
    public int queueSize() {
        synchronized (queue) {
            return queue.size();
        }
    }

    // Проверка, есть ли место в очереди
    public boolean hasSpace() {
        return queue.size() < maxQueueSize;
    }

    // Вывод статуса очереди
    public void showQueueStatus() {
        System.out.println("Текущая очередь: " + queue);
    }
}

public class Customer implements Runnable {
    private final String name;
    private final List<CashRegister> cashRegisters;

    public Customer(String name, List<CashRegister> cashRegisters) {
        this.name = name;
        this.cashRegisters = cashRegisters;
    }

    @Override
    public void run() {
        // Ищем кассу с минимальной очередью
        CashRegister selectedRegister = findQueueWithMinimumCustomers();

        // Пробуем стать в очередь на выбранной кассе
        if (selectedRegister.joinQueue(name)) {
            System.out.println(name + " присоединился к очереди на кассе.");
            try {
                // Симуляция обслуживания клиента
                Thread.sleep(2000);  // Имитируем время обслуживания
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Обслуживаем клиента
            selectedRegister.serveCustomer();
        } else {
            System.out.println(name + " не смог присоединиться к очереди.");
        }
    }

    private CashRegister findQueueWithMinimumCustomers() {
        return cashRegisters.stream()
                .filter(CashRegister::hasSpace)
                .min(Comparator.comparingInt(CashRegister::queueSize))
                .orElseThrow(() -> new IllegalStateException("Нет доступных мест в очереди"));
    }
}

public class Main{

    public static void main(String[] args) throws InterruptedException {
        List<CashRegister> cashRegisters = Arrays.asList(
                new CashRegister(3),  // Касса 1 (макс 3 человека)
                new CashRegister(3),  // Касса 2 (макс 3 человека)
                new CashRegister(3)   // Касса 3 (макс 3 человека)
        );

        ExecutorService executorService = Executors.newFixedThreadPool(6);  // 6 посетителей

        // Создаем и запускаем посетителей
        for (int i = 1; i <= 6; i++) {
            executorService.submit(new Customer("Посетитель " + i, cashRegisters));
        }

        // Закрываем ExecutorService
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
