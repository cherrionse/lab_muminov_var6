package org.example;

// Класс для пассажирского вагона
public class PassengerWagon extends AbstractWagon {
    private int passengerCapacity; // Вместимость пассажиров

    public PassengerWagon(String registrationNumber, double tareWeight, int passengerCapacity) {
        this.registrationNumber = registrationNumber;
        this.tareWeight = tareWeight;
        this.passengerCapacity = passengerCapacity;
        this.status = Status.READY_TO_DEPART;
    }

    @Override
    public void load() {
        System.out.println("Операция загрузки не применима к пассажирскому вагону.");
    }

    @Override
    public void unload() {
        System.out.println("Операция выгрузки не применима к пассажирскому вагону.");
    }

    @Override
    public boolean isFragile() {
        return false;
    }

    @Override
    public boolean isValuable() {
        return false;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    protected String getType() {
        return "Пассажирский";
    }
}
