package VarA.tests;
import VarA.Main;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    @Test
    public void testUnion() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> result = Main.union(set1, set2);

        // Используем HashSet для ожидаемого результата
        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        assertEquals(expected, result);
    }

    @Test
    public void testIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> result = Main.intersection(set1, set2);

        // Используем HashSet для ожидаемого результата
        Set<Integer> expected = new HashSet<>();
        expected.add(2);
        expected.add(3);

        assertEquals(expected, result);
    }
}
