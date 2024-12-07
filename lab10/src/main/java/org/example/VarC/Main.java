package org.example.VarC;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Создание новой директории и файла
            File directory = new File("output_directory");
            if (!directory.exists()) {
                directory.mkdir(); // Создание директории
            }

            File file = new File(directory, "data.txt");
            if (!file.exists()) {
                file.createNewFile(); // Создание файла
                // Запись данных в файл
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.println("123");
                    writer.println("45.67");
                    writer.println("Hello");
                    writer.println("A");
                    writer.println("999");
                    writer.println("12.34");
                }
            }

            // 2. Циклический ввод типа данных из командной строки
            String type;
            while (true) {
                System.out.print("Введите тип данных (Integer, Double, String, Character): ");
                type = scanner.next();

                // Проверка на допустимый тип
                if (isValidType(type)) {
                    break;
                } else {
                    System.out.println("Ошибка: введен некорректный тип данных. Попробуйте снова.");
                }
            }

            // 3. Чтение данных из файла
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }

            // 4. Определение данных указанного типа
            System.out.println("Данные типа " + type + ":");
            for (String line : lines) {
                switch (type) {
                    case "Integer" -> {
                        if (isInteger(line)) {
                            System.out.println(line);
                        }
                    }
                    case "Double" -> {
                        if (isDouble(line)) {
                            System.out.println(line);
                        }
                    }
                    case "String" -> {
                        if (!isInteger(line) && !isDouble(line) && line.length() > 1) {
                            System.out.println(line);
                        }
                    }
                    case "Character" -> {
                        if (line.length() == 1) {
                            System.out.println(line);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    // Метод для проверки, является ли строка целым числом
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Метод для проверки, является ли строка числом с плавающей запятой
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Метод для проверки допустимого типа данных
    public static boolean isValidType(String type) {
        return type.equals("Integer") || type.equals("Double") || type.equals("String") || type.equals("Character");
    }

    public static List<String> filterDataByType(List<String> lines, String type) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            switch (type) {
                case "Integer" -> {
                    if (isInteger(line)) {
                        result.add(line);
                    }
                }
                case "Double" -> {
                    if (isDouble(line)) {
                        result.add(line);
                    }
                }
                case "String" -> {
                    if (!isInteger(line) && !isDouble(line) && line.length() > 1) {
                        result.add(line);
                    }
                }
                case "Character" -> {
                    if (line.length() == 1) {
                        result.add(line);
                    }
                }
                default -> throw new IllegalArgumentException("Unknown type: " + type);
            }
        }
        return result;
    }

}
