package org.example;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Выбор базы данных
        System.out.println("Выберите базу данных:");
        System.out.println("1. PostgreSQL");
        System.out.println("2. H2 (локальная база данных)");

        String dbType = scanner.nextLine().equals("1") ? "postgres" : "h2";

        // Инициализация базы данных
        DatabaseInitializer initializer = new DatabaseInitializer(dbType);
        OrderService service = new OrderService(dbType);

        try {
            // Создаем таблицы и тестовые данные
            initializer.initializeSchemaAndTables();
            initializer.insertSampleData();
        } catch (Exception e) {
            System.out.println("Ошибка при инициализации базы данных: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        boolean exit = false;

        while (!exit) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Добавить заказ");
            System.out.println("3. Добавить связь между заказом и продуктом");
            System.out.println("4. Получить детали заказа");
            System.out.println("5. Выход");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Ошибка: введите число от 1 до 5.");
                scanner.nextLine(); // Очистка некорректного ввода
                continue;
            }

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.println("Введите название продукта:");
                        String name = scanner.nextLine();

                        System.out.println("Введите описание продукта:");
                        String description = scanner.nextLine();

                        System.out.println("Введите цену продукта (через точку):");
                        double price = scanner.nextDouble();

                        service.addProduct(name, description, price);
                        System.out.println("Продукт успешно добавлен!");
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        System.out.println("Введите дату заказа (yyyy-mm-dd hh:mm:ss):");
                        String dateStr = scanner.nextLine();
                        Timestamp orderDate = Timestamp.valueOf(dateStr);

                        service.addOrder(orderDate);
                        System.out.println("Заказ успешно добавлен!");
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении заказа: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Введите ID заказа:");
                        int orderId = scanner.nextInt();

                        System.out.println("Введите ID продукта:");
                        int productId = scanner.nextInt();

                        System.out.println("Введите количество:");
                        int quantity = scanner.nextInt();

                        service.linkOrderWithProduct(orderId, productId, quantity);
                        System.out.println("Связь успешно добавлена!");
                    } catch (Exception e) {
                        System.out.println("Ошибка при добавлении связи: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        System.out.println("Введите ID заказа:");
                        int orderId = scanner.nextInt();

                        // Вызов метода для получения деталей заказа
                        service.getOrderDetails(orderId);
                    } catch (Exception e) {
                        System.out.println("Ошибка при получении деталей заказа: " + e.getMessage());
                    }
                }
                case 5 -> exit = true;

                default -> System.out.println("Неверный выбор! Введите число от 1 до 5.");
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }
}
