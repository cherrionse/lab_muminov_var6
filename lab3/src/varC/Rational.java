package varC;

public class Rational {
    private int numerator;   // Числитель
    private int denominator; // Знаменатель

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель не может быть нулем.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
        System.out.println("Задание выполнил: Муминов Рустам Б762-2");
    }

    // Метод для сокращения дроби
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        // Убедимся, что знаменатель всегда положительный
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Методы доступа
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    // Метод для получения значения в виде double
    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
