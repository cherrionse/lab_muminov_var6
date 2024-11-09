import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//ДОБАВЛЯТЬ ЕЩЕ СВОЙ ВАРИНАТ НАДО БУДЕТ ВАРИАНТ 6!!!
public class HouseManager {
    private List<House> houses;

    // Конструктор
    public HouseManager() {
        houses = new ArrayList<>();
        // Инициализация массива объектов (пример)
            houses.add(new House(1, "A101", 55.5, 3, 2, "Ленина", House.BuildingType.BRICK, 50));
            houses.add(new House(2, "B202", 75.0, 5, 3, "Советская", House.BuildingType.MONOLITH, 40));
            houses.add(new House(3, "C303", 45.0, 2, 1, "Мира", House.BuildingType.PANEL, 30));
            houses.add(new House(4, "D404", 85.0, 7, 3, "Ленина", House.BuildingType.BRICK, 60));
            houses.add(new House(5, "E505", 65.5, 4, 2, "Советская", House.BuildingType.MONOLITH, 45));
        }


    // a) Список квартир, имеющих заданное число комнат
    public List<House> filterByNumberOfRooms(int numberOfRooms) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms) {
                result.add(house);
            }
        }
        return result;
    }

    // b) Список квартир, имеющих заданное число комнат и расположенных на этаже, который находится в заданном промежутке
    public List<House> filterByRoomsAndFloorRange(int numberOfRooms, int floorMin, int floorMax) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getNumberOfRooms() == numberOfRooms &&
                    house.getFloor() >= floorMin &&
                    house.getFloor() <= floorMax) {
                result.add(house);
            }
        }
        return result;
    }

    // c) Список квартир, имеющих площадь, превосходящую заданную
    public List<House> filterByAreaGreaterThan(double area) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (house.getArea() > area) {
                result.add(house);
            }
        }
        return result;
    }

    // Метод для отображения списка квартир
    public void displayHouses(List<House> housesList) {
        for (House house : housesList) {
            System.out.println(house);
        }
    }

    // Метод main для демонстрации
    public static void main(String[] args) {
        HouseManager manager = new HouseManager();
        Scanner scanner = new Scanner(System.in);

        // Пример для пункта a)
        System.out.println("Введите количество комнат для фильтрации:");
        int rooms = scanner.nextInt();
        List<House> filteredByRooms = manager.filterByNumberOfRooms(rooms);
        System.out.println("Квартиры с " + rooms + " комнатами:");
        manager.displayHouses(filteredByRooms);

        // Пример для пункта b)
        System.out.println("\nВведите количество комнат для фильтрации:");
        rooms = scanner.nextInt();
        System.out.println("Введите минимальный этаж:");
        int floorMin = scanner.nextInt();
        System.out.println("Введите максимальный этаж:");
        int floorMax = scanner.nextInt();
        List<House> filteredByRoomsAndFloors = manager.filterByRoomsAndFloorRange(rooms, floorMin, floorMax);
        System.out.println("Квартиры с " + rooms + " комнатами на этажах от " + floorMin + " до " + floorMax + ":");
        manager.displayHouses(filteredByRoomsAndFloors);

        // Пример для пункта c)
        System.out.println("\nВведите минимальную площадь для фильтрации:");
        double area = scanner.nextDouble();
        List<House> filteredByArea = manager.filterByAreaGreaterThan(area);
        System.out.println("Квартиры с площадью больше " + area + " кв.м:");
        manager.displayHouses(filteredByArea);

        scanner.close();
    }
}
