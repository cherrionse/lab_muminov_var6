package VarB.necklace;

import VarB.gems.Gem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Necklace {
    private List<Gem> VarB;

    public Necklace() {
        this.VarB = new ArrayList<>();
    }

    public void addGem(Gem gem) {
        VarB.add(gem);
    }

    public double getTotalWeight() {
        return VarB.stream().mapToDouble(Gem::getWeight).sum();
    }

    public double getTotalValue() {
        return VarB.stream().mapToDouble(Gem::calculateValue).sum();
    }

    public void sortGemsByValue() {
        VarB.sort(Comparator.comparingDouble(Gem::calculateValue).reversed());
    }

    public List<Gem> findGemsByTransparency(double minTransparency, double maxTransparency) {
        return VarB.stream()
                .filter(gem -> gem.getTransparency() >= minTransparency && gem.getTransparency() <= maxTransparency)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ожерелье:\n");
        for (Gem gem : VarB) {
            sb.append(gem).append("\n");
        }
        sb.append("Общий вес: ").append(getTotalWeight()).append(" карат\n");
        sb.append("Общая стоимость: ").append(getTotalValue()).append(" у.е.\n");
        return sb.toString();
    }
}
