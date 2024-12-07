package org.example.VarA;

import java.util.concurrent.*;
import java.util.*;

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
