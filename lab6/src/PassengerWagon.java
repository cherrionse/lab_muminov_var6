// Класс для пассажирского вагона
public class PassengerWagon implements Wagon {
    private String registrationNumber;
    private String destination;
    private String owner;
    private Status status;
    private double tareWeight;
    private int passengerCapacity;

    public PassengerWagon(String registrationNumber, double tareWeight, int passengerCapacity) {
        this.registrationNumber = registrationNumber;
        this.tareWeight = tareWeight;
        this.passengerCapacity = passengerCapacity;
        this.status = Status.READY_TO_DEPART;
    }

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
            System.out.println("Пассажирский вагон в пути к пункту назначения " + destination);
        } else {
            System.out.println("Пассажирский вагон не может отправиться. Текущий статус: " + status);
        }
    }

    @Override
    public void service() {
        status = Status.READY_TO_DEPART;
        System.out.println("Пассажирский вагон обслужен и готов к отправке.");
    }

    @Override
    public void repair() {
        status = Status.IN_REPAIR;
        System.out.println("Пассажирский вагон находится в ремонте.");
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

    // Дополнительный метод для пассажирского вагона
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
}
