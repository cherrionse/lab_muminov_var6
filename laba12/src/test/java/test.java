import org.example.VarA.CashRegister;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test {

    @Test
    public void testJoinQueueSuccess() {
        CashRegister register = new CashRegister(3);  // Ограничение на 3 человека
        System.out.println("Тест: testJoinQueueSuccess");

        // Добавляем клиента и выводим состояние очереди
        assertTrue(register.joinQueue("Customer 1"));
        System.out.println("Текущая очередь: " + register.queueSize());

        assertTrue(register.joinQueue("Customer 2"));
        System.out.println("Текущая очередь: " + register.queueSize());

        assertTrue(register.joinQueue("Customer 3"));
        System.out.println("Текущая очередь: " + register.queueSize());

        // Проверка на полный размер очереди
        assertFalse(register.joinQueue("Customer 4"));  // Очередь полна
        System.out.println("Текущая очередь после попытки добавить 4 клиента: " + register.queueSize());
    }



    @Test
    public void testServeCustomer() {
        CashRegister register = new CashRegister(3);
        register.joinQueue("Customer 1");
        register.joinQueue("Customer 2");

        // Перед обслуживанием размер очереди = 2
        System.out.println("Тест: testServeCustomer");
        System.out.println("Размер очереди до обслуживания: " + register.queueSize());
        Assertions.assertEquals(2, register.queueSize());

        // Обслуживаем клиента
        register.serveCustomer();
        System.out.println("Размер очереди после обслуживания: " + register.queueSize());

        // После обслуживания очередь должна уменьшиться на 1
        Assertions.assertEquals(1, register.queueSize());
    }
    @Test
    public void testHasSpace() {
        CashRegister register = new CashRegister(2);  // Максимум 2 человека
        System.out.println("Тест: testHasSpace");

        System.out.println("Есть ли место в очереди? " + register.hasSpace());
        assertTrue(register.hasSpace());  // Очередь пустая

        register.joinQueue("Customer 1");
        System.out.println("Есть ли место в очереди? (после добавления 1 клиента): " + register.hasSpace());
        assertTrue(register.hasSpace());  // В очереди 1 человек

        register.joinQueue("Customer 2");
        System.out.println("Есть ли место в очереди? (после добавления 2 клиентов): " + register.hasSpace());
        assertFalse(register.hasSpace());  // Очередь заполнена
    }
}
