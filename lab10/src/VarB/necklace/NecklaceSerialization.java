package VarB.necklace;

import VarB.gems.PreciousGem;
import VarB.gems.SemiPreciousGem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class NecklaceSerialization {
    public static void main(String[] args) {
        try {
            // Создаем ожерелье
            Necklace necklace = new Necklace();
            necklace.addGem(new PreciousGem("Diamond", 1.5, 5000, 80));
            necklace.addGem(new SemiPreciousGem("Amethyst", 2.0, 150, 50));
            necklace.addGem(new PreciousGem("Ruby", 1.2, 6000, 90));

            // Записываем в файл
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("necklace.dat"))) {
                oos.writeObject(necklace);
                System.out.println("Ожерелье успешно сохранено в файл.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
