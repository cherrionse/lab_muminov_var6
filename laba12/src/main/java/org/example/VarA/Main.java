package org.example.VarA;

import java.util.concurrent.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Создаём список касс
        List<CashRegister> cashRegisters = Arrays.asList(
                new CashRegister(),  // Касса 1
                new CashRegister(),  // Касса 2
                new CashRegister()   // Касса 3
        );

        // Создаём пул потоков для работы с посетителями
        ExecutorService executorService = Executors.newFixedThreadPool(6);  // 6 посетителей

        // Создаём и запускаем посетителей
        for (int i = 1; i <= 6; i++) {
            executorService.submit(new Customer("Посетитель " + i, cashRegisters));
        }

        // Закрываем ExecutorService
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
