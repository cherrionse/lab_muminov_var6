import VarA.CashRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class test {

    @Test
    void testJoinQueueSuccess() {
        CashRegister register = new CashRegister(3);  // Ограничение на 3 человека
        assertTrue(register.joinQueue("Customer 1"));
        assertTrue(register.joinQueue("Customer 2"));
        assertTrue(register.joinQueue("Customer 3"));
        assertFalse(register.joinQueue("Customer 4"));  // Очередь полна
    }

    @Test
    void testServeCustomer() {
        CashRegister register = new CashRegister(3);
        register.joinQueue("Customer 1");
        register.joinQueue("Customer 2");

        // Перед обслуживанием размер очереди = 2
        Assertions.assertEquals(2, register.queueSize());

        // Обслуживаем клиента
        register.serveCustomer();

        // После обслуживания очередь должна уменьшиться на 1
        Assertions.assertEquals(1, register.queueSize());
    }

    @Test
    void testHasSpace() {
        CashRegister register = new CashRegister(2);  // Максимум 2 человека
        assertTrue(register.hasSpace());  // Очередь пустая
        register.joinQueue("Customer 1");
        assertTrue(register.hasSpace());  // В очереди 1 человек
        register.joinQueue("Customer 2");
        assertFalse(register.hasSpace());  // Очередь заполнена
    }
}
