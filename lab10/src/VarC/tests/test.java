package VarC.tests;

import VarC.Main;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static File testDirectory;
    private static File testFile;

    @BeforeAll
    static void setUpBeforeClass() throws IOException {
        // Создаем тестовую директорию и файл
        testDirectory = new File("test_directory");
        if (!testDirectory.exists()) {
            testDirectory.mkdir();
        }

        testFile = new File(testDirectory, "test_data.txt");
        if (!testFile.exists()) {
            testFile.createNewFile();
        }

        // Записываем тестовые данные в файл
        Files.write(testFile.toPath(), List.of(
                "123",        // Integer
                "45.67",      // Double
                "Hello",      // String
                "A",          // Character
                "999",        // Integer
                "12.34"       // Double
        ));
    }

    @AfterAll
    static void tearDownAfterClass() {
        // Удаляем тестовые файлы и директорию
        if (testFile.exists()) {
            testFile.delete();
        }
        if (testDirectory.exists()) {
            testDirectory.delete();
        }
    }

    @Test
    void testIsInteger() {
        assertTrue(Main.isInteger("123"), "123 должно быть Integer");
        assertTrue(Main.isInteger("-456"), "-456 должно быть Integer");
        assertFalse(Main.isInteger("45.67"), "45.67 не должно быть Integer");
        assertFalse(Main.isInteger("Hello"), "Hello не должно быть Integer");
    }

    @Test
    void testIsDouble() {
        assertTrue(Main.isDouble("45.67"), "45.67 должно быть Double");
        assertTrue(Main.isDouble("-123.45"), "-123.45 должно быть Double");
        assertFalse(Main.isDouble("123"), "123 не должно быть Double");
        assertFalse(Main.isDouble("Hello"), "Hello не должно быть Double");
    }

    @Test
    void testIsValidType() {
        assertTrue(Main.isValidType("Integer"), "Integer — валидный тип");
        assertTrue(Main.isValidType("Double"), "Double — валидный тип");
        assertTrue(Main.isValidType("String"), "String — валидный тип");
        assertTrue(Main.isValidType("Character"), "Character — валидный тип");
        assertFalse(Main.isValidType("Float"), "Float — невалидный тип");
        assertFalse(Main.isValidType("Boolean"), "Boolean — невалидный тип");
    }

    @Test
    void testFilterDataByType_Integer() throws IOException {
        List<String> lines = Files.readAllLines(testFile.toPath());
        List<String> result = Main.filterDataByType(lines, "Integer");
        assertEquals(List.of("123", "999"), result, "Данные типа Integer должны быть [123, 999]");
    }

    @Test
    void testFilterDataByType_Double() throws IOException {
        List<String> lines = Files.readAllLines(testFile.toPath());
        List<String> result = Main.filterDataByType(lines, "Double");
        assertEquals(List.of("45.67", "12.34"), result, "Данные типа Double должны быть [45.67, 12.34]");
    }

    @Test
    void testFilterDataByType_String() throws IOException {
        List<String> lines = Files.readAllLines(testFile.toPath());
        List<String> result = Main.filterDataByType(lines, "String");
        assertEquals(List.of("Hello"), result, "Данные типа String должны быть [Hello]");
    }

    @Test
    void testFilterDataByType_Character() throws IOException {
        List<String> lines = Files.readAllLines(testFile.toPath());
        List<String> result = Main.filterDataByType(lines, "Character");
        assertEquals(List.of("A"), result, "Данные типа Character должны быть [A]");
    }
}
