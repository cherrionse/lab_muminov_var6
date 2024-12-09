package org.example.varB;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

// Муминов Рустам Б762-2 ВАРРИАНТ 6
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
        return text.replaceAll("\\s+", " ").trim(); // Очистка лишних пробелов и табуляций
    }

    // Разбор текста на слова
    public static List<Word> parseWords(String text) {
        // Убираем все лишние символы, оставляя только буквы, цифры и пробелы
        String cleanedText = text.replaceAll("[^\\p{L}\\p{N}\\s]+", ""); // Удаляет символы, кроме букв, цифр и пробелов

        // Разбиваем текст на слова по пробелам
        String[] wordsArray = cleanedText.split("\\s+");

        // Преобразуем массив слов в список объектов Word
        return Arrays.stream(wordsArray)
                .filter(word -> !word.isEmpty()) // Убираем пустые строки
                .map(Word::new) // Создаем объект Word
                .toList();
    }

    public static Map<Character, List<String>> sortWordsByAlphabet(List<Word> words) {
        Map<Character, List<String>> sortedWords = new TreeMap<>();

        for (Word word : words) {
            char firstChar = Character.toLowerCase(word.getWord().charAt(0));
            sortedWords.computeIfAbsent(firstChar, k -> new ArrayList<>())
                    .add(word.getWord());
        }

        // Сортируем списки слов внутри каждой группы в алфавитном порядке
        sortedWords.values().forEach(list -> list.sort(String::compareTo));
        return sortedWords;
    }


    // Печать слов в алфавитном порядке
    public static void printWordsAlphabetically(Map<Character, List<String>> sortedWords) {
        System.out.println("Before printing words");
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, List<String>> entry : sortedWords.entrySet()) {
            char key = Character.toUpperCase(entry.getKey());
            result.append(key).append(":").append("\n");

            for (String word : entry.getValue()) {
                result.append("  ").append(word).append("\n");
            }

            result.append("\n");
        }

        String output = result.toString().trim();
        System.out.println("Generated output: \n" + output);
        System.out.println(output);
    }

    public static String captureOutput(Runnable codeToCapture) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        codeToCapture.run(); // выполнение кода

        System.setOut(originalOut); // восстановление стандартного потока
        return outputStream.toString(); // возвращение захваченного вывода
    }


}
