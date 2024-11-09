// Класс для грузового вагона
public class FreightWagon implements Wagon {
    private String registrationNumber;
    private String destination;
    private String owner;
    private Status status;
    private double tareWeight;
    private boolean fragile;
    private boolean valuable;

    public FreightWagon(String registrationNumber, double tareWeight, boolean fragile, boolean valuable) {
        this.registrationNumber = registrationNumber;
        this.tareWeight = tareWeight;
        this.fragile = fragile;
        this.valuable = valuable;
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
            System.out.println("Freight wagon is en route to " + destination);
        } else {
            System.out.println("Freight wagon cannot depart. Current status: " + status);
        }
    }

    @Override
    public void service() {
        status = Status.READY_TO_DEPART;
        System.out.println("Freight wagon serviced and ready to depart.");
    }

    @Override
    public void repair() {
        status = Status.IN_REPAIR;
        System.out.println("Freight wagon is under repair.");
    }

    @Override
    public void load() {
        if (status == Status.READY_TO_DEPART || status == Status.UNLOADING) {
            status = Status.LOADING;
            System.out.println("Freight wagon is being loaded.");
        }
    }

    @Override
    public void unload() {
        if (status == Status.EN_ROUTE || status == Status.LOADING) {
            status = Status.UNLOADING;
            System.out.println("Freight wagon is being unloaded.");
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
}
