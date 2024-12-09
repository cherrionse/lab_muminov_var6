import org.example.varC.varc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VarCTst {
    @Test
    void testDecompressText_WithSingleCharactersAndNumbers() {
        String compressedText = "A3B4C2";
        String expected = "AAABBBBCC";
        String result = varc.decompressText(compressedText);

        // Проверка результата
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");

        // Вывод в консоль
        System.out.println("Результат testDecompressText_WithSingleCharactersAndNumbers: " + result);
    }

    @Test
    void testDecompressText_WithSpecialCharacters() {
        String compressedText = "*3#2@1";
        String expected = "***##@";
        String result = varc.decompressText(compressedText);

        // Проверка результата
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");

        // Вывод в консоль
        System.out.println("Результат testDecompressText_WithSpecialCharacters: " + result);
    }

    @Test
    void testDecompressText_WithNoNumbers() {
        String compressedText = "ABC";
        String expected = "ABC";
        String result = varc.decompressText(compressedText);

        // Проверка результата
        assertEquals(expected, result, "Если цифры отсутствуют, текст должен остаться без изменений");

        // Вывод в консоль
        System.out.println("Результат testDecompressText_WithNoNumbers: " + result);
    }

    @Test
    void testDecompressText_EmptyInput() {
        String compressedText = "";
        String expected = "";
        String result = varc.decompressText(compressedText);

        // Проверка результата
        assertEquals(expected, result, "Для пустой строки результат должен быть пустым");

        // Вывод в консоль
        System.out.println("Результат testDecompressText_EmptyInput: " + result);
    }
}