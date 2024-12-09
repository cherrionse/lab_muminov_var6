
import org.example.VarC.Main;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.example.VarC.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testIsInteger() {
        System.out.println("Testing valid integers...");
        System.out.println("isInteger('123') = " + isInteger("123"));
        assertTrue(isInteger("123"));

        System.out.println("isInteger('-123') = " + isInteger("-123"));
        assertTrue(isInteger("-123"));

        System.out.println("isInteger('0') = " + isInteger("0"));
        assertTrue(isInteger("0"));

        // Test invalid integers
        System.out.println("Testing invalid inputs...");
        System.out.println("isInteger('123.45') = " + isInteger("123.45"));
        assertFalse(isInteger("123.45"));

        System.out.println("isInteger('abc') = " + isInteger("abc"));
        assertFalse(isInteger("abc"));

        System.out.println("isInteger('') = " + isInteger(""));
        assertFalse(isInteger(""));

        System.out.println("isInteger('123a') = " + isInteger("123a"));
        assertFalse(isInteger("123a"));
    }

    @Test
    public void testIsDouble() {
        // Test valid doubles
        System.out.println("Testing valid doubles...");
        System.out.println("isDouble('123.45') = " + isDouble("123.45"));
        assertTrue(isDouble("123.45"));

        System.out.println("isDouble('-123.45') = " + isDouble("-123.45"));
        assertTrue(isDouble("-123.45"));

        System.out.println("isDouble('0.0') = " + isDouble("0.0"));
        assertTrue(isDouble("0.0"));

        // Test invalid inputs
        System.out.println("Testing invalid inputs...");
        System.out.println("isDouble('123') = " + isDouble("123"));
        assertTrue(isDouble("123"));  // Valid double, as an integer is also a valid floating-point number

        System.out.println("isDouble('abc') = " + isDouble("abc"));
        assertFalse(isDouble("abc"));

        System.out.println("isDouble('') = " + isDouble(""));
        assertFalse(isDouble(""));

        System.out.println("isDouble('123a') = " + isDouble("123a"));
        assertFalse(isDouble("123a"));

        System.out.println("isDouble('12.34.56') = " + isDouble("12.34.56"));
        assertFalse(isDouble("12.34.56"));
    }

    @Test
    public void testFilterDataByType() {
        List<String> lines = List.of("123", "45.67", "Hello", "A", "123a", "", "3.14", "abc", "B");

        // Тест для типа Integer
        System.out.println("Тестируем фильтрацию для 'Integer'...");
        List<String> resultIntegers = filterDataByType(lines, "Integer");
        System.out.println("Результат для Integer: " + resultIntegers);
        assertEquals(List.of("123"), resultIntegers);

        // Тест для типа Double
        System.out.println("Тестируем фильтрацию для 'Double'...");
        List<String> resultDoubles = filterDataByType(lines, "Double");
        System.out.println("Результат для Double: " + resultDoubles);
        assertEquals(List.of("45.67", "3.14"), resultDoubles);

        // Тест для типа String
        System.out.println("Тестируем фильтрацию для 'String'...");
        List<String> resultStrings = filterDataByType(lines, "String");
        System.out.println("Результат для String: " + resultStrings);
        assertEquals(List.of("Hello", "abc"), resultStrings);

        // Тест для типа Character
        System.out.println("Тестируем фильтрацию для 'Character'...");
        List<String> resultCharacters = filterDataByType(lines, "Character");
        System.out.println("Результат для Character: " + resultCharacters);
        assertEquals(List.of("A", "B"), resultCharacters);
    }

}
