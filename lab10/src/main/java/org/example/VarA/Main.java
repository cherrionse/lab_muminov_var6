package org.example.VarA;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        // Пути к файлам
        String inputFilePath = "lab10\\src\\input.txt";
        String wordListFilePath = "lab10\\src\\wordlist.txt";


        try {
            // Чтение текста стихотворения из файла
            String inputText = Files.readString(Paths.get(inputFilePath));

            // Чтение списка слов из файла
            List<String> wordsToCount = Files.readAllLines(Paths.get(wordListFilePath));

            // Подсчёт частот слов
            Map<String, Integer> wordFrequencies = countWordFrequencies(inputText, wordsToCount);

            // Сортировка слов по частоте и по алфавиту
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequencies.entrySet());
            sortedEntries.sort((e1, e2) -> {
                int freqCompare = e1.getValue().compareTo(e2.getValue()); // Сравниваем по частоте
                if (freqCompare == 0) {
                    return e1.getKey().compareTo(e2.getKey()); // Если частоты равны, сравниваем по алфавиту
                }
                return freqCompare;
            });

            // Вывод результата
            System.out.println("Результат:");
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файлов: " + e.getMessage());
        }
    }

    /**
     * Подсчитывает частоту слов из заданного списка в тексте.
     *
     * @param text         текст для анализа
     * @param wordsToCount список слов для подсчёта
     * @return карта, где ключ — слово, значение — его частота
     */
    public static Map<String, Integer> countWordFrequencies(String text, List<String> wordsToCount) {
        // Карта для хранения частоты слов
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Приводим текст к нижнему регистру
        text = text.toLowerCase();

        // Разбиваем текст на строки
        String[] lines = text.split("\n");

        // Создаём набор слов для подсчёта (убираем лишние пробелы и приводим к нижнему регистру)
        Set<String> wordSet = new HashSet<>(wordsToCount.stream()
                .map(String::toLowerCase) // Приводим к нижнему регистру
                .map(String::trim)       // Убираем пробелы
                .toList());


        for (String line : lines) {

            String[] words = line.toLowerCase().split("[^а-яёa-z]+");
            for (String word : words) {
                if (wordSet.contains(word)) {
                    wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
                }
            }
        }

        for (String word : wordsToCount) {
            wordFrequencies.putIfAbsent(word.toLowerCase().trim(), 0);
        }

        return wordFrequencies;
    }
}