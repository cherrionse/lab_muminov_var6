package varB;
import java.util.*;
//Муминов Рустам Б762-2 ВАРРИАНТ 6
public class VarB {
    public static void main(String[] args) {
        // Пример текста
        String text = """
            Программирование — это процесс создания программ.
            Цель программирования: решение задач.
            Задача программиста: писать код эффективно.
            
            Табуляции и лишние пробелы  заменяются      одним пробелом.
        """;

        // Очистка текста от табуляций и лишних пробелов
        text = cleanText(text);

        // Разбор текста на слова
        List<Word> words = parseWords(text);

        // Сортировка слов в алфавитном порядке
        Map<Character, List<String>> sortedWords = sortWordsByAlphabet(words);

        // Вывод результата
        printWordsAlphabetically(sortedWords);
    }

    // Удаление лишних пробелов и табуляций
    public static String cleanText(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    // Разбор текста на слова
    public static List<Word> parseWords(String text) {
        String[] wordArray = text.split("[\\s,.;!?]+");
        List<Word> words = new ArrayList<>();
        for (String w : wordArray) {
            if (!w.isEmpty()) {
                words.add(new Word(w));
            }
        }
        return words;
    }

    // Сортировка слов в алфавитном порядке по первой букве
    public static Map<Character, List<String>> sortWordsByAlphabet(List<Word> words) {
        Map<Character, List<String>> sortedWords = new TreeMap<>();
        for (Word word : words) {
            char firstChar = Character.toLowerCase(word.getWord().charAt(0));
            sortedWords.putIfAbsent(firstChar, new ArrayList<>());
            sortedWords.get(firstChar).add(word.getWord());
        }
        for (List<String> list : sortedWords.values()) {
            Collections.sort(list);
        }
        return sortedWords;
    }

    // Печать слов в алфавитном порядке
    public static void printWordsAlphabetically(Map<Character, List<String>> sortedWords) {
        for (Map.Entry<Character, List<String>> entry : sortedWords.entrySet()) {
            System.out.println("\n" + Character.toUpperCase(entry.getKey()) + ":");
            for (String word : entry.getValue()) {
                System.out.println("  " + word);
            }
        }
    }
}

// Класс для представления слова
public class Word {
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
