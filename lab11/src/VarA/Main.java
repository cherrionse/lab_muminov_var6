package VarA;
import java.util.Set;
import java.util.HashSet;
//Муминов Рустам Варинат 6
public class Main{

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultSet = new HashSet<>(set1);  // создаем новый набор на основе первого
        resultSet.addAll(set2);  // добавляем все элементы из второго набора
        return resultSet;
    }

    // Метод для нахождения пересечения двух наборов
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultSet = new HashSet<>(set1);  // создаем новый набор на основе первого
        resultSet.retainAll(set2);  // оставляем только общие элементы с вторым набором
        return resultSet;
    }

    public static void main(String[] args) {
        // Пример создания двух множеств
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // Пример использования метода объединения
        Set<Integer> unionSet = union(set1, set2);
        System.out.println("Объединение множеств: " + unionSet); // [1, 2, 3, 4, 5, 6]

        // Пример использования метода пересечения
        Set<Integer> intersectionSet = intersection(set1, set2);
        System.out.println("Пересечение множеств: " + intersectionSet); // [3, 4]
    }
}
