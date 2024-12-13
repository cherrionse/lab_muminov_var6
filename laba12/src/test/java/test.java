import org.example.VarA.CashRegister;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertTrue;

public class test {

    @Test
    public void testJoinQueue() {
        CashRegister register = new CashRegister();  // Очередь без ограничений
        System.out.println("Тест: testJoinQueue");

        // Добавляем клиентов и проверяем размер очереди
        assertTrue(register.joinQueue("Customer 1"));
        System.out.println("Текущая очередь: " + register.queueSize());
        Assertions.assertEquals(1, register.queueSize());

        assertTrue(register.joinQueue("Customer 2"));
        System.out.println("Текущая очередь: " + register.queueSize());
        Assertions.assertEquals(2, register.queueSize());

        assertTrue(register.joinQueue("Customer 3"));
        System.out.println("Текущая очередь: " + register.queueSize());
        Assertions.assertEquals(3, register.queueSize());

        // Продолжаем добавлять клиентов без ограничений
        assertTrue(register.joinQueue("Customer 4"));
        System.out.println("Текущая очередь: " + register.queueSize());
        Assertions.assertEquals(4, register.queueSize());
    }

    @Test
    public void testServeCustomer() {
        CashRegister register = new CashRegister();
        System.out.println("Тест: testServeCustomer");

        register.joinQueue("Customer 1");
        register.joinQueue("Customer 2");

        // Перед обслуживанием размер очереди = 2
        System.out.println("Размер очереди до обслуживания: " + register.queueSize());
        Assertions.assertEquals(2, register.queueSize());

        // Обслуживаем клиента
        register.serveCustomer();
        System.out.println("Размер очереди после обслуживания: " + register.queueSize());
        Assertions.assertEquals(1, register.queueSize());

        // Обслуживаем ещё одного клиента
        register.serveCustomer();
        System.out.println("Размер очереди после повторного обслуживания: " + register.queueSize());
        Assertions.assertEquals(0, register.queueSize());
    }

    @Test
    public void testQueueStatus() {
        CashRegister register = new CashRegister();
        System.out.println("Тест: testQueueStatus");

        register.joinQueue("Customer 1");
        register.joinQueue("Customer 2");

        System.out.println("Текущая очередь: ");
        register.showQueueStatus();
        Assertions.assertEquals(2, register.queueSize());

        // Очистка очереди
        register.clearQueue();
        System.out.println("Очередь очищена.");
        Assertions.assertEquals(0, register.queueSize());
    }
}
