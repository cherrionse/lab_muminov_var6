package org.example.VarB;

//import VarB.connector.NecklaceConnector;
//import VarB.gems.*;
//import VarB.necklace.Necklace;

import org.example.VarB.connector.NecklaceConnector;

import org.example.VarB.gems.*;
import org.example.VarB.necklace.Necklace;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Necklace necklace;

        String filePath = "lab10\\src\\necklace.txt";  // Путь к файлу

        // Попытка загрузить данные из файла при запуске программы
        try {
            necklace = NecklaceConnector.loadFromFile(filePath);
            System.out.println("Данные из файла загружены успешно:");
            System.out.println(necklace);
        } catch (IOException e) {
            System.err.println("Не удалось загрузить данные из файла. Используется пустое ожерелье.");
            necklace = new Necklace();
        }

        while (true) {
            System.out.println("\nЗадание выполнил: Муминов Рустам Б762-2");
            System.out.println("Меню:");
            System.out.println("1. Добавить драгоценный камень");
            System.out.println("2. Добавить полудрагоценный камень");
            System.out.println("3. Показать ожерелье");
            System.out.println("4. Отсортировать камни по стоимости");
            System.out.println("5. Найти камни по диапазону прозрачности");
            System.out.println("6. Сохранить ожерелье в файл");
            System.out.println("7. Загрузить ожерелье из файла");
            System.out.println("8. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Название: ");
                    String name = scanner.next();

                    // Validate weight input
                    double weight = 0;
                    boolean validWeight = false;
                    while (!validWeight) {
                        System.out.print("Вес (в каратах): ");
                        if (scanner.hasNextDouble()) {
                            weight = scanner.nextDouble();
                            validWeight = true;
                        } else {
                            System.out.println("Ошибка ввода! Пожалуйста, введите числовое значение для веса.");
                            scanner.next(); // Clear the invalid input
                        }
                    }

                    double price = 0;
                    boolean validPrice = false;
                    while (!validPrice) {
                        System.out.print("Цена за карат: ");
                        if (scanner.hasNextDouble()) {
                            price = scanner.nextDouble();
                            validPrice = true;
                        } else {
                            System.out.println("Ошибка ввода! Пожалуйста, введите числовое значение для цены.");
                            scanner.next();
                        }
                    }

                    System.out.print("Прозрачность (0-100): ");
                    double transparency = scanner.nextDouble();

                    necklace.addGem(new SemiPreciousGem(name, weight, price, transparency));
                }

                case 6 -> {
                    try {
                        NecklaceConnector.saveToFile(necklace, filePath);
                        System.out.println("Ожерелье успешно сохранено в файл.");
                    } catch (IOException e) {
                        System.err.println("Ошибка сохранения: " + e.getMessage());
                    }
                }
                case 7 -> {
                    try {
                        necklace = NecklaceConnector.loadFromFile(filePath);
                        System.out.println("Данные из файла загружены успешно:");
                        System.out.println(necklace);
                    } catch (IOException e) {
                        System.err.println("Ошибка загрузки: " + e.getMessage());
                    }
                }
                case 8 -> {
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
