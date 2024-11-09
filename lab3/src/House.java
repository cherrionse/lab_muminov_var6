public class House {
    private int id;
    private String apartmentNumber; // Номер квартиры
    private double area; // Площадь
    private int floor; // Этаж
    private int numberOfRooms; // Количество комнат
    private String street; // Улица
    private String buildingType; // Тип здания
    private int serviceLife; // Срок эксплуатации

    // Конструктор по умолчанию
    public House() {
    }

    // Конструктор с параметрами
    public House(int id, String apartmentNumber, double area, int floor, int numberOfRooms,
                 String street, String buildingType, int serviceLife) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.serviceLife = serviceLife;
    }

    // Дополнительные конструкторы (пример)
    public House(int id, String apartmentNumber, double area, int floor, int numberOfRooms) {
        this(id, apartmentNumber, area, floor, numberOfRooms, "Unknown", "Unknown", 0);
    }

    // Методы доступа (Setters и Getters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    // Метод toString()
    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", area=" + area +
                ", floor=" + floor +
                ", numberOfRooms=" + numberOfRooms +
                ", street='" + street + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", serviceLife=" + serviceLife +
                '}';
    }
}
