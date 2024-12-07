package org.example.VarB.necklace;

import org.example.VarB.gems.Gem;
import org.example.VarB.gems.SemiPreciousGem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Necklace implements Serializable {
    private List<Gem> gems; // Список камней

    // Пример static поля (не сериализуется)
    private static final long serialVersionUID = 1L;

    public Necklace() {
        this.gems = new ArrayList<>();
    }

    public void addGem(SemiPreciousGem gem) {
        gems.add(gem);
    }

    public void sortGemsByValue() {
        gems.sort(Comparator.comparingDouble(Gem::getValue));
    }

    public List<Gem> findGemsByTransparency(double minTransparency, double maxTransparency) {
        List<Gem> result = new ArrayList<>();
        for (Gem gem : gems) {
            if (gem.getTransparency() >= minTransparency && gem.getTransparency() <= maxTransparency) {
                result.add(gem);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ожерелье:\n");
        for (Gem gem : gems) {
            sb.append(" - ").append(gem).append("\n");
        }
        return sb.toString();
    }

    public void printGems() {
        if (gems.isEmpty()) {
            System.out.println("Ожерелье пусто.");
        } else {
            for (Gem gem : gems) {
                System.out.println(gem);
            }
        }
    }

    public List<Gem> getGems() {
        return gems;
    }

}
