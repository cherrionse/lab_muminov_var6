
import VarB.gems.*;
import VarB.necklace.Necklace;
import java.util.*;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Necklace necklace = new Necklace();

        // Добавляем заранее определенные камни
        necklace.addGem(new PreciousGem("Алмаз", 5.5, 15000, 90));
        necklace.addGem(new PreciousGem("Желтый Алмаз", 3.5, 12000, 90));
        necklace.addGem(new PreciousGem("Голублй Алмаз", 3.5, 12000, 90));
        necklace.addGem(new PreciousGem("РозовыйАлмаз", 2.5, 25000, 90));
        necklace.addGem(new PreciousGem("Рубин", 2.0, 3000, 80));
        necklace.addGem(new SemiPreciousGem("Аметист", 3.0, 1500, 70));
        necklace.addGem(new SemiPreciousGem("Топаз", 2.5, 1200, 75));

        System.out.println("\nКамни: ");
        necklace.printGems();

        while (true) {
            System.out.println("Задание выполнил: Муминов Рустам Б762-2");
            System.out.println("Меню:");
            System.out.println("1. Добавить драгоценный камень");
            System.out.println("2. Добавить полудрагоценный камень");
            System.out.println("3. Сортировать камни по стоимости");
            System.out.println("4. Найти камни по диапазону прозрачности");
            System.out.println("5. Выход");
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
                case 3 -> {
                    necklace.sortGemsByValue();
                    System.out.println("\nКамни отсортированы по стоимости:");
                    System.out.println(necklace);
                }
                case 4 -> {
                    System.out.print("Введите минимальную прозрачность: ");
                    double minTransparency = scanner.nextDouble();
                    System.out.print("Введите максимальную прозрачность: ");
                    double maxTransparency = scanner.nextDouble();
                    List<Gem> filteredGems = necklace.findGemsByTransparency(minTransparency, maxTransparency);
                    if (filteredGems.isEmpty()) {
                        System.out.println("Нет камней в заданном диапазоне прозрачности.");
                    } else {
                        System.out.println("\nКамни с прозрачностью в диапазоне " + minTransparency + " - " + maxTransparency + ":");
                        filteredGems.forEach(System.out::println);


                        double totalWeight = filteredGems.stream().mapToDouble(Gem::getWeight).sum();
                        double totalValue = filteredGems.stream().mapToDouble(Gem::calculateValue).sum();

                        System.out.println("Общий вес камней в диапазоне: " + totalWeight + " каратов");
                        System.out.println("Общая стоимость камней в диапазоне: " + totalValue + " у.е.");
                    }
                }
                case 5 -> {
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

}
