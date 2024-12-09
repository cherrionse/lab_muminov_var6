
import org.example.VarB.connector.NecklaceConnector;
import org.example.VarB.gems.Gem;
import org.example.VarB.gems.SemiPreciousGem;
import org.example.VarB.necklace.Necklace;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VarB_test {
    private Necklace necklace;

    @BeforeEach
    void setUp() {
        necklace = new Necklace();
    }

    @Test
    void testFindGemsByTransparency() {

        Necklace necklace = new Necklace();

        Gem ruby = new SemiPreciousGem("Ruby", 5.0, 1000.0, 85.0);
        Gem sapphire = new SemiPreciousGem("Sapphire", 3.0, 1500.0, 90.0);
        Gem emerald = new SemiPreciousGem("Emerald", 4.5, 1200.0, 80.0);
        Gem diamond = new SemiPreciousGem("Diamond", 2.0, 5000.0, 95.0);
        Gem amethyst = new SemiPreciousGem("Amethyst", 3.5, 800.0, 70.0);

        // Add gems to the necklace
        necklace.addGem((SemiPreciousGem) ruby);
        necklace.addGem((SemiPreciousGem) sapphire);
        necklace.addGem((SemiPreciousGem) emerald);
        necklace.addGem((SemiPreciousGem) diamond);
        necklace.addGem((SemiPreciousGem) amethyst);


        double minTransparency = 80.0;
        double maxTransparency = 90.0;


        List<Gem> filteredGems = necklace.findGemsByTransparency(minTransparency, maxTransparency);
        System.out.println("Filtered gems based on transparency range (" + minTransparency + " - " + maxTransparency + "):");
        for (Gem gem : filteredGems) {
            System.out.println(gem);
        }
        assertEquals(3, filteredGems.size(), "There should be 3 gems in the given transparency range.");


        assertTrue(filteredGems.contains(ruby), "The Ruby gem should be included in the result.");
        assertTrue(filteredGems.contains(sapphire), "The Sapphire gem should be included in the result.");
        assertTrue(filteredGems.contains(emerald), "The Emerald gem should be included in the result.");
        assertFalse(filteredGems.contains(diamond), "The Diamond gem should not be included in the result.");
        assertFalse(filteredGems.contains(amethyst), "The Amethyst gem should not be included in the result.");
    }

    @Test
    void testSortGemsByValue() {

        Necklace necklace = new Necklace();

        Gem ruby = new SemiPreciousGem("Ruby", 5.0, 1000.0, 85.0);   // Value = 5000.0
        Gem sapphire = new SemiPreciousGem("Sapphire", 3.0, 1500.0, 90.0);  // Value = 4500.0
        Gem emerald = new SemiPreciousGem("Emerald", 4.5, 1200.0, 80.0);  // Value = 5400.0
        Gem diamond = new SemiPreciousGem("Diamond", 2.0, 5000.0, 95.0);  // Value = 10000.0
        Gem amethyst = new SemiPreciousGem("Amethyst", 3.5, 800.0, 70.0); // Value = 2800.0

        // Add gems to the necklace
        necklace.addGem((SemiPreciousGem) ruby);
        necklace.addGem((SemiPreciousGem) sapphire);
        necklace.addGem((SemiPreciousGem) emerald);
        necklace.addGem((SemiPreciousGem) diamond);
        necklace.addGem((SemiPreciousGem) amethyst);

        // Before sorting, the gems should not be sorted
        System.out.println("Before sorting:");
        for (Gem gem : necklace.getGems()) {
            System.out.println(gem);
        }

        // Call the sort method
        necklace.sortGemsByValue();

        // After sorting, the gems should be sorted by value in ascending order
        System.out.println("\nAfter sorting by value:");
        for (Gem gem : necklace.getGems()) {
            System.out.println(gem);
        }

        // Get the list of gems after sorting
        List<Gem> sortedGems = necklace.getGems();

        // Check that the gems are sorted by value in ascending order
        assertEquals(amethyst, sortedGems.get(0), "Amethyst should be the first gem.");
        assertEquals(sapphire, sortedGems.get(1), "Sapphire should be the second gem.");
        assertEquals(ruby, sortedGems.get(2), "Ruby should be the third gem.");
        assertEquals(emerald, sortedGems.get(3), "Emerald should be the fourth gem.");
        assertEquals(diamond, sortedGems.get(4), "Diamond should be the fifth gem.");
    }

    @Test
    void testSaveAndLoadNecklace() throws IOException, ClassNotFoundException {
        String filePath = "test_necklace.dat";

        necklace.addGem(new SemiPreciousGem("Рубин", 2.0, 3000, 80));
        necklace.addGem(new SemiPreciousGem("Аметист", 3.0, 1500, 70));

        // Сохраняем ожерелье в файл
        NecklaceConnector.saveToFile(necklace, filePath);

        // Загружаем ожерелье из файла
        Necklace loadedNecklace = NecklaceConnector.loadFromFile(filePath);

        // Проверяем, что данные совпадают
        assertEquals(necklace.getGems().size(), loadedNecklace.getGems().size());
        assertEquals(necklace.getGems().get(0).getName(), loadedNecklace.getGems().get(0).getName());
        assertEquals(necklace.getGems().get(1).getName(), loadedNecklace.getGems().get(1).getName());

        // Удаляем тестовый файл
        new File(filePath).delete();
    }
}
