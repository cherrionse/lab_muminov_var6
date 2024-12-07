package org.example.VarA;

import java.io.*;
import java.util.*;
//Муминов Рустам Б762-2 ВАРИАНТ 6
public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\mumin\\IdeaProjects\\lab9\\src\\numbers.txt";
        List<Double> numbers = new ArrayList<>();

        try {
            numbers = readAndProcessFile(filePath);
            double sum = calculateSum(numbers);
            double average = numbers.isEmpty() ? 0 : sum / numbers.size();

            System.out.println("Считанные числа: " + numbers);
            System.out.println("Сумма: " + sum);
            System.out.println("Среднее значение: " + average);
        } catch (CustomFileProcessingException e) {
            System.err.println("Ошибка обработки файла: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Ошибка: недостаточно памяти для обработки файла.");
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    /**
     * Чтение и обработка файла
     */
    public static List<Double> readAndProcessFile(String filePath) throws CustomFileProcessingException {
        List<Double> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split("\\s+");
                    if (parts.length < 2) {
                        throw new CustomFileProcessingException("Ошибка формата: Некорректная строка");
                    }

                    // Парсинг числа
                    double number = Double.parseDouble(parts[0].replace(",", "."));

                    // Проверка допустимости значения числа
                    if (Double.isInfinite(number)) {
                        throw new CustomFileProcessingException("Недопустимое значение числа: " + parts[0]);
                    }

                    numbers.add(number);
                } catch (NumberFormatException e) {
                    throw new CustomFileProcessingException("Ошибка формата: " + line, e);
                }
            }
        } catch (IOException e) {
            throw new CustomFileProcessingException("Ошибка при чтении файла: " + filePath, e);
        }

        return numbers;
    }



    public static double calculateSum(List<Double> numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }
}

