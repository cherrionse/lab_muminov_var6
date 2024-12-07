import VarB.ParkingLot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class test {

    private ParkingLot parkingLot;

    @BeforeEach
    public void setUp() {
        parkingLot = new ParkingLot(3);  // Создаем парковку с 3 местами
    }

    @Test
    public void testParkCar_Success() {
        // Проверяем, что место свободно и машина может припарковаться
        assertTrue(parkingLot.parkCar(), "Машина должна быть припаркована.");
        assertFalse(parkingLot.hasFreeSpace(), "Должно остаться 2 свободных места.");
    }

    @Test
    public void testRemoveCar_Success() {
        // Паркуем машину, затем удаляем
        parkingLot.parkCar();
        assertTrue(parkingLot.removeCar(), "Машина должна быть удалена.");
        assertTrue(parkingLot.hasFreeSpace(), "После удаления машины должно быть свободное место.");
    }

    @Test
    public void testParkCar_Fail_WhenFull() {
        // Паркуем 3 машины, парковка будет заполнена
        parkingLot.parkCar();
        parkingLot.parkCar();
        parkingLot.parkCar();

        // Проверяем, что парковка заполнена, и машина не может припарковаться
        assertFalse(parkingLot.parkCar(), "Парковка должна быть заполнена, и не должно быть свободных мест.");
    }

    @Test
    public void testRemoveCar_Fail_WhenEmpty() {
        // Попробуем удалить машину, не припарковав её
        assertFalse(parkingLot.removeCar(), "Парковка пуста, не должно быть машины для удаления.");
    }

    @Test
    public void testShowParkingStatus() {
        // Паркуем машину
        parkingLot.parkCar();

        // Проверяем, что статус парковки выводится корректно
        parkingLot.showParkingStatus();  // Этот метод выводит статус на экран
    }
}
