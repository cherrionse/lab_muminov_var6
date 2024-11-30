package varA;

import java.util.Scanner;
//Муминов Рустам Б762-2 ВАРРИАНТ 6
public class VAr6{

    /**
     * Processes an array of strings based on the given flag and symbol.
     *
     * @param lines  Array of strings to process.
     * @param flag   Operation type (0: remove symbol, 1: insert symbol).
     * @param symbol Symbol to remove or insert.
     * @param k      Position to insert the symbol (used only if flag == 1).
     * @return Modified array of strings.
     */
    public static String[] processLines(String[] lines, int flag, char symbol, int k) {
        for (int i = 0; i < lines.length; i++) {
            if (flag == 0) {

                lines[i] = lines[i].replace(Character.toString(symbol), "");
            } else if (flag == 1) {
                if (k >= 0 && k < lines[i].length()) {
                    lines[i] = lines[i].substring(0, k + 1) + symbol + lines[i].substring(k + 1);
                } else if (k >= lines[i].length()) {

                    lines[i] += symbol;
                }
            }
        }
        return lines;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of lines
        System.out.print("Введите количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // Input lines
        String[] lines = new String[n];
        System.out.println("Введите строки:");
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.nextLine();
        }

        // Input flag
        System.out.print("Введите признак (0 - удалить символ, 1 - вставить символ): ");
        int flag = scanner.nextInt();

        // Input symbol
        System.out.print("Введите символ для обработки: ");
        char symbol = scanner.next().charAt(0);

        // Input position k (if flag == 1)
        int k = -1;
        if (flag == 1) {
            System.out.print("Введите позицию k (начиная с 0): ");
            k = scanner.nextInt();
        }

        // Process the lines
        String[] processedLines = processLines(lines, flag, symbol, k);

        // Output the result
        System.out.println("Результат:");
        for (String line : processedLines) {
            System.out.println(line);
        }
    }
}