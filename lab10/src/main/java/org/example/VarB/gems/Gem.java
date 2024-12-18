package org.example.VarB.gems;

import java.io.Serializable;
import java.util.Objects;

public abstract class Gem implements Serializable {
    private String name;
    private double weight;         // Вес в каратах
    private double pricePerCarat;  // Цена за карат
    private double transparency;   // Прозрачность (0-100)

    private transient double cachedValue; // Кешированная стоимость

    public Gem(String name, double weight, double pricePerCarat, double transparency) {
        this.name = name;
        this.weight = weight;
        this.pricePerCarat = pricePerCarat;
        this.transparency = transparency;
        calculateValue(); // Инициализируем кеш
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerCarat() {
        return pricePerCarat;
    }

    public double getTransparency() {
        return transparency;
    }

    public double getValue() {
        if (cachedValue == 0) calculateValue(); // Пересчитываем, если кэш пуст
        return cachedValue;
    }

    private void calculateValue() {
        this.cachedValue = this.weight * this.pricePerCarat;
    }


    public void setWeight(double weight) {
        this.weight = weight;
        this.cachedValue = 0; // Сброс кэша
    }

    public void setPricePerCarat(double pricePerCarat) {
        this.pricePerCarat = pricePerCarat;
        this.cachedValue = 0; // Сброс кэша
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same reference
        if (obj == null || getClass() != obj.getClass()) return false; // Null check and class type check
        Gem gem = (Gem) obj; // Type casting
        return Double.compare(gem.weight, weight) == 0 &&
                Double.compare(gem.pricePerCarat, pricePerCarat) == 0 &&
                Double.compare(gem.transparency, transparency) == 0 &&
                Objects.equals(name, gem.name); // Comparing name and other fields
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, pricePerCarat, transparency); // Hashing all relevant fields
    }

    @Override
    public String toString() {
        return name + " (Вес: " + weight + " карат, Цена за карат: " + pricePerCarat +
                ", Прозрачность: " + transparency + "%, Стоимость: " + getValue() + ")";
    }
}
