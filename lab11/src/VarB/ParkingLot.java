package VarB;
//Муминов Рустам Б762-2 ВАРИНАТ 6
public class ParkingLot {
    private boolean[] parkingSpaces;  // Массив для хранения состояния мест на парковке
    private int capacity;  // Вместимость парковки

    // Конструктор для инициализации парковки
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new boolean[capacity];  // Все места изначально свободны
    }

    // Метод для парковки машины
    public boolean parkCar() {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (!parkingSpaces[i]) {  // Если место свободно
                parkingSpaces[i] = true;  // Паркуем машину
                return true;  // Машина успешно припаркована
            }
        }
        return false;  // Парковка заполнена, места нет
    }

    // Метод для того, чтобы машина уехала
    public boolean removeCar() {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i]) {  // Если место занято
                parkingSpaces[i] = false;  // Освобождаем место
                return true;  // Машина успешно уехала
            }
        }
        return false;  // Парковка пустая, нет машины для удаления
    }

    // Метод для отображения текущего состояния парковки
    public void showParkingStatus() {
        System.out.println("Parking status: ");
        for (int i = 0; i < parkingSpaces.length; i++) {
            System.out.println("Place " + (i + 1) + ": " + (parkingSpaces[i] ? "Occupied" : "Free"));
        }
    }

    // Метод для проверки, есть ли свободные места
    public boolean hasFreeSpace() {
        for (boolean place : parkingSpaces) {
            if (!place) {  // Если есть хотя бы одно свободное место
                return true;
            }
        }
        return false;
    }
}
