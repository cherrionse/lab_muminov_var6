import org.junit.jupiter.api.Test;
import varC.varc;

import static org.junit.jupiter.api.Assertions.*;

class VarCTst {

    @Test
    void testDecompressText_WithSingleCharactersAndNumbers() {
        String compressedText = "A3B4C2";
        String expected = "AAABBBBCC";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");
    }

    @Test
    void testDecompressText_WithWordsAndNumbers() {
        String compressedText = "Программирование2 это1 интересный1 процесс3!";
        String expected = "ПрограммированиеПрограммирование это интересный процесспроцесспроцесс!";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");
    }

    @Test
    void testDecompressText_WithSpecialCharacters() {
        String compressedText = "*3#2@1";
        String expected = "***##@";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");
    }

    @Test
    void testDecompressText_WithNoNumbers() {
        String compressedText = "ABC";
        String expected = "ABC";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Если цифры отсутствуют, текст должен остаться без изменений");
    }

    @Test
    void testDecompressText_WithMixedInput() {
        String compressedText = "A3B2 Привет2!";
        String expected = "AAABB ПриветПривет!";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Распакованный текст должен соответствовать ожидаемому");
    }

    @Test
    void testDecompressText_EmptyInput() {
        String compressedText = "";
        String expected = "";
        String result = varc.decompressText(compressedText);
        assertEquals(expected, result, "Для пустой строки результат должен быть пустым");
    }
}
