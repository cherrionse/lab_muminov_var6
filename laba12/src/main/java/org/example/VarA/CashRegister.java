package org.example.VarA;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Муминов Рустам Б762-2 ВАРИАНТ 6
public class CashRegister {
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();

    // Попытка стать в очередь
    public boolean joinQueue(String customer) {
        System.out.println("Попытка добавить клиента: " + customer + ". Текущий размер очереди: " + queue.size());
        queue.offer(customer); // Без ограничений просто добавляем в очередь
        System.out.println("Клиент добавлен: " + customer + ". Новый размер очереди: " + queue.size());
        return true;
    }

    // Очистка очереди
    public void clearQueue() {
        queue.clear();
    }

    // Обслуживание клиента (удаление из очереди)
    public void serveCustomer() {
        String customer = queue.poll(); // Удаляем клиента из головы очереди
        if (customer != null) {
            System.out.println("Обслуживаем клиента: " + customer);
        } else {
            System.out.println("Очередь пуста. Никого обслуживать.");
        }
    }

    // Получение текущей длины очереди
    public int queueSize() {
        return queue.size();
    }

    // Проверка, есть ли место в очереди (всегда true, т.к. ограничений нет)
    public boolean hasSpace() {
        return true;
    }

    // Вывод статуса очереди
    public void showQueueStatus() {
        System.out.println("Текущая очередь: " + queue);
    }
}
