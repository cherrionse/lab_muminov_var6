package org.example.VarB.connector;



import org.example.VarB.gems.Gem;
import org.example.VarB.gems.SemiPreciousGem;
import org.example.VarB.necklace.Necklace;

import java.io.*;

import java.io.*;
import java.util.*;

public class NecklaceConnector {
    public static void saveToFile(Necklace necklace, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Gem gem : necklace.getGems()) {
                // Записываем камни в формате: имя, вес, цена за карат, прозрачность
                writer.write(gem.getName() + "," + gem.getWeight() + "," + gem.getPricePerCarat() + "," + gem.getTransparency());
                writer.newLine();
            }
            System.out.println("Ожерелье успешно сохранено в файл: " + filePath);
        }
    }

    public static Necklace loadFromFile(String filePath) throws IOException {
        Necklace necklace = new Necklace();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Предположим, что данные разделены запятой

                if (parts.length == 4) {
                    String name = parts[0].trim();
                    double weight = Double.parseDouble(parts[1].trim());
                    double price = Double.parseDouble(parts[2].trim());  // Price per carat
                    double transparency = Double.parseDouble(parts[3].trim());

                    // Добавляем камень в ожерелье
                    necklace.addGem(new SemiPreciousGem(name, weight, price, transparency));
                }
            }
            System.out.println("Ожерелье успешно загружено из файла: " + filePath);
        }

        return necklace;
    }
}
