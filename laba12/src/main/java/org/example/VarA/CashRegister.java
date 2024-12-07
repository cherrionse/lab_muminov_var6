package org.example.VarA;

import java.util.LinkedList;
import java.util.Queue;

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