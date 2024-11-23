
import VarB.gems.*;
import VarB.necklace.Necklace;
import java.util.*;

public class MainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Necklace necklace = new Necklace();

        // Добавляем заранее определенные камни
        necklace.addGem(new PreciousGem("Алмаз", 1.5, 5000, 90));
        necklace.addGem(new PreciousGem("Рубин", 2.0, 3000, 80));
        necklace.addGem(new SemiPreciousGem("Аметист", 3.0, 1500, 70));
        necklace.addGem(new SemiPreciousGem("Топаз", 2.5, 1200, 75));

        // Автоматически выводим все камни
        System.out.println("\nСодержимое ожерелья:");
        necklace.printGems();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить драгоценный камень");
            System.out.println("2. Добавить полудрагоценный камень");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Чтобы поглотить лишний символ новой строки после ввода числа

            switch (choice) {
                case 1: // Добавить драгоценный камень
                    System.out.print("Введите название драгоценного камня: ");
                    String preciousName = scanner.nextLine();
                    System.out.print("Введите вес (в каратах): ");
                    double preciousWeight = scanner.nextDouble();
                    System.out.print("Введите цену: ");
                    double preciousPrice = scanner.nextDouble();
                    System.out.print("Введите прозрачность (%): ");
                    double preciousTransparency = scanner.nextDouble();
                    necklace.addGem(new PreciousGem(preciousName, preciousWeight, preciousPrice, preciousTransparency));
                    System.out.println("Драгоценный камень добавлен.");
                    break;

                case 2: // Добавить полудрагоценный камень
                    System.out.print("Введите название полудрагоценного камня: ");
                    String semiPreciousName = scanner.nextLine();
                    System.out.print("Введите вес (в каратах): ");
                    double semiPreciousWeight = scanner.nextDouble();
                    System.out.print("Введите цену: ");
                    double semiPreciousPrice = scanner.nextDouble();
                    System.out.print("Введите прозрачность (%): ");
                    double semiPreciousTransparency = scanner.nextDouble();
                    necklace.addGem(new SemiPreciousGem(semiPreciousName, semiPreciousWeight, semiPreciousPrice, semiPreciousTransparency));
                    System.out.println("Полудрагоценный камень добавлен.");
                    break;

                case 6: // Выход
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}