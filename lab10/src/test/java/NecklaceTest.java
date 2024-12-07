
import org.example.VarB.connector.NecklaceConnector;
import org.example.VarB.gems.Gem;
import org.example.VarB.gems.SemiPreciousGem;
import org.example.VarB.necklace.Necklace;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NecklaceTest {
    private Necklace necklace;

    @BeforeEach
    void setUp() {
        necklace = new Necklace();
    }

    @Test
    void testAddPreciousGem() {
        SemiPreciousGem gem = new SemiPreciousGem("Алмаз", 5.0, 15000, 90);
        necklace.addGem(gem);

        assertEquals(1, necklace.getGems().size());
        assertEquals(gem, necklace.getGems().get(0));
    }


    @Test
    void testAddSemiPreciousGem() {
        SemiPreciousGem gem = new SemiPreciousGem("Топаз", 2.0, 1200, 75);
        necklace.addGem(gem);

        assertEquals(1, necklace.getGems().size());
        assertEquals(gem, necklace.getGems().get(0));
    }

    @Test
    void testFindGemsByTransparency() {
        necklace.addGem(new SemiPreciousGem("Алмаз", 5.0, 15000, 90));
        necklace.addGem(new SemiPreciousGem("Топаз", 2.0, 1200, 75));

        var filteredGems = necklace.findGemsByTransparency(80, 95);

        assertEquals(1, filteredGems.size());
        assertEquals("Алмаз", filteredGems.get(0).getName());
    }

    @Test
    public void testSortGemsByValue() {

        Necklace necklace = new Necklace();

        // Добавляем тестовые данные
        necklace.addGem(new SemiPreciousGem("Алмаз", 5.5, 15000, 90));  // Стоимость: 82500
        necklace.addGem(new SemiPreciousGem("Топаз", 2.5, 1200, 75)); // Стоимость: 3000
        necklace.addGem(new SemiPreciousGem("Рубин", 2.0, 3000, 80));     // Стоимость: 6000

        // Пересчитываем стоимость перед сортировкой (для кэшированных значений)
        for (Gem gem : necklace.getGems()) {
            gem.getValue(); // Это вызовет `calculateValue()`, если кэш пуст
        }

        // Сортируем камни по стоимости
        necklace.sortGemsByValue();

        // Проверяем порядок элементов
        List<Gem> sortedGems = necklace.getGems();
        assertEquals("Топаз", sortedGems.get(0).getName());  // Самый дешёвый
        assertEquals("Рубин", sortedGems.get(1).getName());  // Средний
        assertEquals("Алмаз", sortedGems.get(2).getName());  // Самый дорогой
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
