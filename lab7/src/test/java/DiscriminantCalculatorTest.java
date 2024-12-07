
import org.example.DiscriminantCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class DiscriminantCalculatorTest {

    // Тест для положительного дискриминанта
    @Test
    void testPositiveDiscriminant() {
        // Лямбда-выражение для вычисления дискриминанта
        DiscriminantCalculator discriminant = (a, b, c) -> b * b - 4 * a * c;

        // Пример с положительным дискриминантом
        double a = 1.0, b = -3.0, c = 2.0;
        double expected = 1.0; // b^2 - 4ac = (-3)^2 - 4*1*2 = 1
        Assertions.assertEquals(expected, discriminant.calculate(a, b, c), 0.0001);
    }

    // Тест для нулевого дискриминанта
    @Test
    void testZeroDiscriminant() {
        DiscriminantCalculator discriminant = (a, b, c) -> b * b - 4 * a * c;

        // Пример с нулевым дискриминантом
        double a = 1.0, b = -2.0, c = 1.0;
        double expected = 0.0; // b^2 - 4ac = (-2)^2 - 4*1*1 = 0
        Assertions.assertEquals(expected, discriminant.calculate(a, b, c), 0.0001);
    }

    // Тест для отрицательного дискриминанта
    @Test
    void testNegativeDiscriminant() {
        DiscriminantCalculator discriminant = (a, b, c) -> b * b - 4 * a * c;

        // Пример с отрицательным дискриминантом
        double a = 1.0, b = 1.0, c = 1.0;
        double expected = -3.0; // b^2 - 4ac = (1)^2 - 4*1*1 = -3
        Assertions.assertEquals(expected, discriminant.calculate(a, b, c), 0.0001);
    }
}
