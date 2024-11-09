package VarB.gems;

public abstract class Gem {
    private String name;
    private double weight; // в каратах
    private double price; // стоимость за карат
    private double transparency; // от 0 до 100%

    public Gem(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public double getWeight() {
        return weight;
    }

    public double getTransparency() {
        return transparency;
    }

    public double calculateValue() {
        return weight * price;
    }

    @Override
    public String toString() {
        return String.format("%s (Вес: %.2f карат, Цена: %.2f, Прозрачность: %.2f%%)",
                name, weight, calculateValue(), transparency);
    }
}
