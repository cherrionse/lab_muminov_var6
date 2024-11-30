package varB.tests;

import org.junit.jupiter.api.Test;
import varB.VarB;
import varB.Word;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class VarBTest {

    @Test
    void testCleanText() {
        String input = "Программирование\t\t— это   процесс  создания   программ.\nЦель\t\tпрограммирования:   решение задач.";
        String expected = "Программирование — это процесс создания программ. Цель программирования: решение задач.";
        String result = VarB.cleanText(input);
        assertEquals(expected, result, "Текст должен быть очищен от лишних пробелов и табуляций.");
    }

    @Test
    void testParseWords() {
        String input = "Программирование — это процесс создания программ.";
        List<String> expectedWords = List.of("Программирование", "это", "процесс", "создания", "программ");
        List<Word> result = VarB.parseWords(input);
        List<String> resultWords = result.stream().map(Word::getWord).toList();
        assertEquals(expectedWords, resultWords, "Слова должны быть корректно извлечены из текста.");
    }

    @Test
    void testSortWordsByAlphabet() {
        List<Word> words = List.of(
                new Word("программирование"),
                new Word("процесс"),
                new Word("это"),
                new Word("создание"),
                new Word("цель")
        );
        Map<Character, List<String>> result = VarB.sortWordsByAlphabet(words);

        Map<Character, List<String>> expected = new TreeMap<>();
        expected.put('п', List.of("процесс", "программирование"));
        expected.put('с', List.of("создание"));
        expected.put('ц', List.of("цель"));
        expected.put('э', List.of("это"));

        assertEquals(expected, result, "Слова должны быть корректно отсортированы по алфавиту и сгруппированы.");
    }

    @Test
    void testPrintWordsAlphabetically() {
        Map<Character, List<String>> sortedWords = new TreeMap<>();
        sortedWords.put('а', List.of("алгоритм", "анализ"));
        sortedWords.put('б', List.of("база", "библиотека"));
        sortedWords.put('п', List.of("процесс", "программирование"));

        String expectedOutput = """
                
                А:
                  алгоритм
                  анализ
                
                Б:
                  база
                  библиотека
                
                П:
                  процесс
                  программирование
                """;

        // Захватываем стандартный вывод в строку
        String actualOutput = captureOutput(() -> VarB.printWordsAlphabetically(sortedWords));

        assertEquals(expectedOutput.strip(), actualOutput.strip(), "Вывод должен быть корректно отсортированным и форматированным.");
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

        return outputStream.toString();
    }
}
