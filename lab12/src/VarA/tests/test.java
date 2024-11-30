package VarA.tests;
import VarA.CashRegister;
import VarA.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.concurrent.*;

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

class CustomerTest {

    @Test
    void testCustomerJoinQueue() throws InterruptedException {
        // Установка касс
        List<CashRegister> cashRegisters = Arrays.asList(
                new CashRegister(2),
                new CashRegister(2),
                new CashRegister(2)
        );

        // Создаем поток для каждого посетителя
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Создаем 3 посетителей
        executor.submit(new Customer("Customer 1", cashRegisters));
        executor.submit(new Customer("Customer 2", cashRegisters));
        executor.submit(new Customer("Customer 3", cashRegisters));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Проверка, что очереди не переполнены
        for (CashRegister register : cashRegisters) {
            assertTrue("Очередь на кассе переполнена", register.queueSize() <= 2);
        }
    }
}

class RestaurantSimulationTest {

    @Test
    void testRestaurantSimulation() throws InterruptedException {
        List<CashRegister> cashRegisters = Arrays.asList(
                new CashRegister(3),  // Касса с лимитом 3
                new CashRegister(3),
                new CashRegister(3)
        );

        ExecutorService executor = Executors.newFixedThreadPool(6);  // 6 посетителей

        // Создаем 6 посетителей
        for (int i = 1; i <= 6; i++) {
            executor.submit(new Customer("Customer " + i, cashRegisters));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Проверяем, что хотя бы одна касса не переполнена
        boolean noOverloadedRegister = cashRegisters.stream()
                .anyMatch(register -> register.queueSize() <= 3);

        assertTrue("Нет доступной кассы с пустой очередью", noOverloadedRegister);
    }
}
