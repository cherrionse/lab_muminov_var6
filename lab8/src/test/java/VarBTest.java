
import org.example.varB.VarB;
import org.example.varB.Word;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import static org.example.varB.VarB.cleanText;
import static org.example.varB.VarB.printWordsAlphabetically;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VarBTest {

    @Test
    public void testCleanText() {
        String input = "Программирование\t\t— это   процесс  создания   программ. \nЦель \t\tпрограммирования: решение задач. ";
        String expected = "Программирование — это процесс создания программ. Цель программирования: решение задач.";
        String actual = cleanText(input);
        assertEquals(expected, actual);
    }



    @Test
    void testParseWords() {
        String input = "Программирование — это процесс создания программ.";
        List<String> expectedWords = List.of("Программирование", "это", "процесс", "создания", "программ");
        List<Word> result = VarB.parseWords(input);
        List<String> resultWords = result.stream().map(Word::getWord).toList();

        assertEquals("Слова должны быть корректно извлечены из текста.", expectedWords, resultWords);

        // Вывод результата в консоль
        System.out.println("Результат testParseWords: " + resultWords);
    }

    @Test
    void testSortWordsByAlphabet() {

        List<Word> words = List.of(
                new Word("banana"),
                new Word("apple"),
                new Word("grape"),
                new Word("cherry"),
                new Word("kiwi")
        );


        Map<Character, List<String>> result = VarB.sortWordsByAlphabet(words);


        Map<Character, List<String>> expected = new TreeMap<>();
        expected.put('a', List.of("apple"));
        expected.put('b', List.of("banana"));
        expected.put('c', List.of("cherry"));
        expected.put('g', List.of("grape"));
        expected.put('k', List.of("kiwi"));


        assertEquals("Слова должны быть корректно отсортированы по алфавиту и сгруппированы.", expected, result);


        System.out.println("Результат testSortWordsByAlphabet: " + result);
        System.out.flush(); // Принудительно очищает вывод


        // Дополнительно, если вывод по-прежнему не работает
        assertTrue(result.size() > 0, "Результат!");

    }

    // Вспомогательный метод для захвата стандартного вывода
    private String captureOutput(Runnable task) {
        var outputStream = new java.io.ByteArrayOutputStream();
        var printStream = new java.io.PrintStream(outputStream);
        var originalOut = System.out;

        try {
            System.setOut(printStream);
            task.run();
        } finally {
            System.setOut(originalOut);
        }


        String actualOutput = outputStream.toString();
        System.out.println("Captured Output: " + actualOutput);
        return actualOutput;
    }


}
