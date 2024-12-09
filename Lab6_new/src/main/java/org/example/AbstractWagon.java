package org.example;

public abstract class AbstractWagon implements Wagon {
    protected String registrationNumber; // Регистрационный номер
    protected String destination;        // Назначение
    protected String owner;              // Владелец
    protected Status status;             // Статус
    protected double tareWeight;         // Пустой вес

    @Override
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public double getTareWeight() {
        return tareWeight;
    }


    @Override
    public void sendToDestination() {
        if (status == Status.READY_TO_DEPART) {
            status = Status.EN_ROUTE;
            System.out.println(getType() + " вагон в пути к " + destination);
        } else {
            System.out.println(getType() + " вагон не может отправиться. Текущий статус: " + status);
        }
    }

    @Override
    public void service() {
        status = Status.READY_TO_DEPART;
        System.out.println(getType() + " вагон обслужен и готов к отправке.");
    }

    @Override
    public void repair() {
        status = Status.IN_REPAIR;
        System.out.println(getType() + " вагон находится в ремонте.");
    }

    @Override
    public void load() {
        System.out.println("Операция загрузки не применима в абстрактном классе.");
    }

    @Override
    public void unload() {
        System.out.println("Операция выгрузки не применима в абстрактном классе.");
    }


    protected abstract String getType();
}
