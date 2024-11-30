package VarA.tests;
import VarA.CustomFileProcessingException;
import VarA.Main;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static final String TEST_FILE_PATH = "test_numbers.txt";

    /**
     * Метод для подготовки временного файла для тестов.
     */
    @BeforeEach
    void setupTestFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("1234.56 en-US\n");
            writer.write("1234,56 fr-FR\n");
            writer.write("-9876.54321 en-GB\n");
        }
    }

    /**
     * Метод для удаления временного файла после тестов.
     */
    @AfterEach
    void cleanupTestFile() {
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            assertTrue(file.delete(), "Не удалось удалить тестовый файл.");
        }
    }

    @Test
    @DisplayName("Тест чтения и обработки файла")
    void testReadAndProcessFile() throws Exception {
        List<Double> numbers = Main.readAndProcessFile(TEST_FILE_PATH);

        assertEquals(3, numbers.size(), "Количество чисел должно быть 3");
        assertEquals(1234.56, numbers.get(0), 0.01, "Первое число должно быть 1234.56");
        assertEquals(1234.56, numbers.get(1), 0.01, "Второе число должно быть 1234.56");
        assertEquals(-9876.54, numbers.get(2), 0.01, "Третье число должно быть -9876.54321");
    }

    @Test
    @DisplayName("Тест вычисления суммы")
    void testCalculateSum() {
        List<Double> numbers = Arrays.asList(1.1, 2.2, 3.3);
        double sum = Main.calculateSum(numbers);

        assertEquals(6.6, sum, 0.01, "Сумма должна быть равна 6.6");
    }

    @Test
    @DisplayName("Тест обработки пустого файла")
    void testReadAndProcessEmptyFile() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            // Создаем пустой файл
        }

        List<Double> numbers = Main.readAndProcessFile(TEST_FILE_PATH);

        assertTrue(numbers.isEmpty(), "Список чисел должен быть пустым");
    }

    @Test
    @DisplayName("Тест обработки некорректного формата файла")
    void testReadAndProcessInvalidFileFormat() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("Некорректная строка\n");
        } catch (IOException e) {
            fail("Не удалось подготовить тестовый файл");
        }

        Exception exception = assertThrows(CustomFileProcessingException.class, () -> {
            Main.readAndProcessFile(TEST_FILE_PATH);
        });

        System.out.println("Сообщение исключения: " + exception.getMessage());

        assertTrue(exception.getMessage().contains("Ошибка формата"),
                "Сообщение об ошибке должно содержать 'Ошибка формата'");
    }

    @Test
    @DisplayName("Тест обработки недопустимого значения числа")
    void testReadAndProcessInvalidNumber() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("1e500 en-US\n"); // Число выходит за пределы Double.MAX_VALUE
        } catch (IOException e) {
            fail("Не удалось подготовить тестовый файл");
        }

        Exception exception = assertThrows(CustomFileProcessingException.class, () -> {
            Main.readAndProcessFile(TEST_FILE_PATH);
        });

        System.out.println("Сообщение исключения: " + exception.getMessage());

        assertTrue(exception.getMessage().contains("Недопустимое значение числа"),
                "Сообщение об ошибке должно содержать 'Недопустимое значение числа'");
    }


    @Test
    @DisplayName("Тест обработки отсутствующего файла")
    void testFileNotFound() {
        Exception exception = assertThrows(CustomFileProcessingException.class, () -> {
            Main.readAndProcessFile("nonexistent_file.txt");
        });

        assertTrue(exception.getMessage().contains("Ошибка при чтении файла"),
                "Сообщение об ошибке должно содержать 'Ошибка при чтении файла'");
    }
}
