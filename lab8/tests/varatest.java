import org.junit.jupiter.api.Test;
import varA.VAr6;

import static org.junit.jupiter.api.Assertions.*;

class VAr6Test {

    // Тест: удаление символа из строк
    @Test
    void testRemoveSymbol() {
        // Исходный массив строк
        String[] input = {"apple", "banana", "cherry"};
        int flag = 0; // Признак: удалить символ
        char symbol = 'a'; // Символ для удаления

        // Ожидаемый результат
        String[] expected = {"pple", "bnn", "cherry"};

        // Выполнение метода
        String[] result = VAr6.processLines(input, flag, symbol, -1);

        // Проверка результата
        assertArrayEquals(expected, result, "Символы должны быть удалены из строк.");
    }

    // Тест: добавление символа в заданную позицию
    @Test
    void testInsertSymbolAtValidPosition() {
        // Исходный массив строк
        String[] input = {"apple", "banana", "cherry"};
        int flag = 1; // Признак: вставить символ
        char symbol = 'z'; // Символ для вставки
        int k = 1; // Позиция: после 1-го символа

        // Ожидаемый результат
        String[] expected = {"apzple", "baznana", "chzerry"};

        // Выполнение метода
        String[] result = VAr6.processLines(input, flag, symbol, k);

        // Проверка результата
        assertArrayEquals(expected, result, "Символ должен быть вставлен в указанную позицию.");
    }

    // Тест: добавление символа в конец строки, если позиция превышает длину строки
    @Test
    void testInsertSymbolAtEnd() {
        // Исходный массив строк
        String[] input = {"apple", "banana", "cherry"};
        int flag = 1; // Признак: вставить символ
        char symbol = 'z'; // Символ для вставки
        int k = 10; // Позиция: превышает длину строки

        // Ожидаемый результат
        String[] expected = {"applez", "bananaz", "cherryz"};

        // Выполнение метода
        String[] result = VAr6.processLines(input, flag, symbol, k);

        // Проверка результата
        assertArrayEquals(expected, result, "Символ должен быть добавлен в конец строки, если k больше длины строки.");
    }

    // Тест: некорректная позиция для вставки (отрицательное значение)
    @Test
    void testInsertSymbolAtNegativePosition() {
        // Исходный массив строк
        String[] input = {"apple", "banana", "cherry"};
        int flag = 1; // Признак: вставить символ
        char symbol = 'z'; // Символ для вставки
        int k = -1; // Позиция: некорректная (отрицательная)

        // Ожидаемый результат
        String[] expected = {"apple", "banana", "cherry"}; // Без изменений

        // Выполнение метода
        String[] result = VAr6.processLines(input, flag, symbol, k);

        // Проверка результата
        assertArrayEquals(expected, result, "При некорректной позиции k изменения не должны происходить.");
    }
}
