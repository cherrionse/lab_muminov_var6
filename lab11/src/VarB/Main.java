package VarB;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);  // Создаем парковку с 5 местами

        // Пример парковки машины
        System.out.println("Попытка припарковать машину...");
        if (parkingLot.parkCar()) {
            System.out.println("Машина припаркована успешно.");
        } else {
            System.out.println("Нет доступных мест для парковки.");
        }

        // Показать текущее состояние парковки
        parkingLot.showParkingStatus();

        // Пример удаления машины
        System.out.println("\nПопытка удалить машину...");
        if (parkingLot.removeCar()) {
            System.out.println("Машина удалена успешно.");
        } else {
            System.out.println("Нет машины для удаления.");
        }

        // Показать обновленное состояние парковки
        parkingLot.showParkingStatus();
    }
}
