import org.example.VarA.Main;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class VarA_test {

    @Test
    public void testCountWordFrequencies() {
        // Входной текст
        String inputText = """
            Моя душа, как ястреб дикий,
            Стремится в небо на простор,
            Подстерегает птичьи крики,
            Моя душа, как ястреб дикий.
        """;

        // Список слов для подсчёта
        List<String> wordList = List.of("душа", "ястреб", "душу", "вера");

        // Ожидаемый результат
        Map<String, Integer> expectedFrequencies = Map.of(
                "душу", 0,
                "вера", 0,
                "душа", 2,
                "ястреб", 2
        );

        // Вызов метода для подсчёта частот
        Map<String, Integer> actualFrequencies = Main.countWordFrequencies(inputText, wordList);

        // Вывод в консоль
        System.out.println("Ожидаемые частоты: " + expectedFrequencies);
        System.out.println("Фактические частоты: " + actualFrequencies);

        // Сравнение ожидаемого и фактического результата
        assertEquals(expectedFrequencies, actualFrequencies, "Частоты слов должны совпадать.");
    }

    @Test
    public void testEmptyText() {
        // Пустой текст
        String inputText = "";

        // Список слов для подсчёта
        List<String> wordList = List.of("вера", "ястреб", "душу");

        // Ожидаемый результат
        Map<String, Integer> expectedFrequencies = Map.of(
                "вера", 0,
                "ястреб", 0,
                "душу", 0
        );

        // Вызов метода для подсчёта частот
        Map<String, Integer> actualFrequencies = Main.countWordFrequencies(inputText, wordList);

        // Вывод в консоль
        System.out.println("Ожидаемые частоты: " + expectedFrequencies);
        System.out.println("Фактические частоты: " + actualFrequencies);

        // Сравнение ожидаемого и фактического результата
        assertEquals(expectedFrequencies, actualFrequencies, "Все частоты должны быть равны 0.");
    }

    @Test
    public void testCaseInsensitive() {
        // Текст с разным регистром
        String inputText = """
            ВЕРА вера Вера
            Душу душу ДУШУ
        """;

        // Список слов для подсчёта
        List<String> wordList = List.of("вера", "душу");

        // Ожидаемый результат
        Map<String, Integer> expectedFrequencies = Map.of(
                "вера", 3,
                "душу", 3
        );

        // Вызов метода для подсчёта частот
        Map<String, Integer> actualFrequencies = Main.countWordFrequencies(inputText, wordList);

        // Вывод в консоль
        System.out.println("Ожидаемые частоты: " + expectedFrequencies);
        System.out.println("Фактические частоты: " + actualFrequencies);

        // Сравнение ожидаемого и фактического результата
        assertEquals(expectedFrequencies, actualFrequencies, "Частоты слов должны учитывать регистр.");
    }
}
