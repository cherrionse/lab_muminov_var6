package VarB.connector;

import VarB.necklace.Necklace;

import java.io.*;

public class NecklaceConnector {

    // Сохранение объекта ожерелья в файл
    public static void saveToFile(Necklace necklace, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(necklace);
            System.out.println("Ожерелье успешно сохранено в файл: " + filePath);
        }
    }

    // Загрузка объекта ожерелья из файла
    public static Necklace loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Ожерелье успешно загружено из файла: " + filePath);
            return (Necklace) ois.readObject();
        }
    }
}
