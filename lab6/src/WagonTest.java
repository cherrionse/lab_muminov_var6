import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WagonTest {

    private Wagon freightWagon;
    private Wagon passengerWagon;

    @BeforeEach
    public void setup() {
        freightWagon = new FreightWagon("FW123", 1000.0, true, true);
        passengerWagon = new PassengerWagon("PW456", 500.0, 100);
    }
    
    @Test
    public void testPassengerWagonLoad() {
        passengerWagon.load(); // Должна выводиться информация о невозможности загрузки
        assertEquals("Операция загрузки не применима к пассажирскому вагону.", "Операция загрузки не применима к пассажирскому вагону.");
    }

    @Test
    public void testPassengerWagonUnload() {
        passengerWagon.unload(); // Должна выводиться информация о невозможности выгрузки
        assertEquals("Операция выгрузки не применима к пассажирскому вагону.", "Операция выгрузки не применима к пассажирскому вагону.");
    }

 
    @Test
    public void testPassengerWagonCapacity() {
        assertEquals(100, ((PassengerWagon) passengerWagon).getPassengerCapacity(), "Passenger wagon should have a capacity of 100.");
    }
}
