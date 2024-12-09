
import org.example.VarA.CustomFileProcessingException;
import org.example.VarA.Main;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.example.VarA.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class unittest {
    @Test
    public void testCalculateSum() {
        // Список чисел
        List<Double> numbers = List.of(1.0, 2.5, 3.3, 4.2);

        // Ожидаемый результат (1.0 + 2.5 + 3.3 + 4.2)
        double expectedSum = 1.0 + 2.5 + 3.3 + 4.2; // 11.0

        // Вызов метода для вычисления суммы
        double actualSum = calculateSum(numbers);

        // Вывод в консоль (по желанию)
        System.out.println("Ожидаемая сумма: " + expectedSum);
        System.out.println("Фактическая сумма: " + actualSum);

        // Сравнение ожидаемой и фактической суммы
        assertEquals(expectedSum, actualSum, 0.0001, "Сумма должна совпадать.");
    }

}
