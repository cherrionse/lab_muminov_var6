package org.example;

// Класс для грузового вагона
public class FreightWagon extends AbstractWagon {
    private boolean fragile;  // Хрупкий ли вагон
    private boolean valuable; // Дорогой ли вагон

    public FreightWagon(String registrationNumber, double tareWeight, boolean fragile, boolean valuable) {
        this.registrationNumber = registrationNumber;
        this.tareWeight = tareWeight;
        this.fragile = fragile;
        this.valuable = valuable;
        this.status = Status.READY_TO_DEPART;
    }

    @Override
    public void load() {
        if (status == Status.READY_TO_DEPART || status == Status.UNLOADING) {
            status = Status.LOADING;
            System.out.println("Грузовой вагон загружается.");
        }
    }

    @Override
    public void unload() {
        if (status == Status.EN_ROUTE || status == Status.LOADING) {
            status = Status.UNLOADING;
            System.out.println("Грузовой вагон разгружается.");
        }
    }

    @Override
    public boolean isFragile() {
        return fragile;
    }

    @Override
    public boolean isValuable() {
        return valuable;
    }

    @Override
    protected String getType() {
        return "Грузовой";
    }
}
