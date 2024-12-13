package org.example.VarA;

import java.util.Comparator;
import java.util.List;

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
        selectedRegister.joinQueue(name);
        System.out.println(name + " присоединился к очереди на кассе.");

        try {
            // Симуляция обслуживания клиента
            Thread.sleep(2000); // Имитируем время обслуживания
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Обслуживаем клиента
        selectedRegister.serveCustomer();
    }

    private CashRegister findQueueWithMinimumCustomers() {
        return cashRegisters.stream()
                .min(Comparator.comparingInt(CashRegister::queueSize))
                .orElseThrow(() -> new IllegalStateException("Нет доступных касс"));
    }
}
