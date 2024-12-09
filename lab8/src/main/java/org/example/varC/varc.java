package org.example.varC;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class varc {
    public static void main(String[] args) {
        // Пример сжатого текста
        String compressedText = "A3B4C2 Программирование2 это1 интересный1 процесс3!";

        // Распаковка текста
        String decompressedText = decompressText(compressedText);

        // Вывод результата
        System.out.println("Сжатый текст: " + compressedText);
        System.out.println("Распакованный текст: " + decompressedText);
    }

    /**
     * Метод для распаковки текста, сжатого методом RLE
     */
    public static String decompressText(String compressedText) {
        // Регулярное выражение для поиска пар "буква/слово + число"
        Pattern pattern = Pattern.compile("([а-яА-Яa-zA-Z]+|[^а-яА-Яa-zA-Z\\d\\s])\\d*");
        Matcher matcher = pattern.matcher(compressedText);

        StringBuilder decompressed = new StringBuilder();

        while (matcher.find()) {
            String group = matcher.group(); // Группа вида "A3", "B4", "процесс3"

            // Извлечение символов и количества
            String letters = group.replaceAll("\\d+", ""); // Убираем цифры (A, процесс)
            String digits = group.replaceAll("\\D+", ""); // Убираем буквы (3, 4)
            int count = digits.isEmpty() ? 1 : Integer.parseInt(digits); // Если числа нет, берем 1

            // Добавляем символы count раз
            decompressed.append(letters.repeat(count));
        }

        return decompressed.toString();
    }
}