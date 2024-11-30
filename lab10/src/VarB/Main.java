package VarB;

import VarB.connector.NecklaceConnector;
import VarB.gems.*;
import VarB.necklace.Necklace;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Necklace necklace;

        String filePath = "C:\\Users\\mumin\\IdeaProjects\\lab10\\src\\VarB\\necklace.dat"; // Путь к файлу

        // Попытка загрузить данные из файла при запуске программы
        try {
            necklace = NecklaceConnector.loadFromFile(filePath);
            System.out.println("Данные из файла загружены успешно:");
            System.out.println(necklace);
        } catch (IOException | ClassNotFoundException e) {
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
                    System.out.print("Вес (в каратах): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Цена за карат: ");
                    double price = scanner.nextDouble();
                    System.out.print("Прозрачность (0-100): ");
                    double transparency = scanner.nextDouble();
                    necklace.addGem(new PreciousGem(name, weight, price, transparency));
                }
                case 2 -> {
                    System.out.print("Название: ");
                    String name = scanner.next();
                    System.out.print("Вес (в каратах): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Цена за карат: ");
                    double price = scanner.nextDouble();
                    System.out.print("Прозрачность (0-100): ");
                    double transparency = scanner.nextDouble();
                    necklace.addGem(new SemiPreciousGem(name, weight, price, transparency));
                }
                case 3 -> System.out.println(necklace);
                case 4 -> {
                    necklace.sortGemsByValue();
                    System.out.println("Камни отсортированы по стоимости.");
                }
                case 5 -> {
                    System.out.print("Минимальная прозрачность: ");
                    double minTransparency = scanner.nextDouble();
                    System.out.print("Максимальная прозрачность: ");
                    double maxTransparency = scanner.nextDouble();
                    var filteredGems = necklace.findGemsByTransparency(minTransparency, maxTransparency);
                    System.out.println("Камни с заданной прозрачностью:");
                    filteredGems.forEach(System.out::println);
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
                    } catch (IOException | ClassNotFoundException e) {
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
