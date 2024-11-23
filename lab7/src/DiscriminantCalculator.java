import java.util.Scanner;

@FunctionalInterface
public interface DiscriminantCalculator {
    // Муминов Рустам Б762-2
    double calculate(double a, double b, double c);

    public static void main(String[] args) {
        // Реализация метода через лямбда-выражение
        DiscriminantCalculator discriminant = (a, b, c) -> b * b - 4 * a * c;

        // Используем Scanner для ввода коэффициентов
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффициенты квадратного уравнения:");

        // Ввод коэффициентов a, b, c
        System.out.print("Введите значение a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите значение b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите значение c: ");
        double c = scanner.nextDouble();

        // Вычисление дискриминанта
        double result = discriminant.calculate(a, b, c);

        // Вывод результата
        System.out.println("Дискриминант для a = " + a + ", b = " + b + ", c = " + c + " равен: " + result);
    }
}
