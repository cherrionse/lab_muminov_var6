

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
    public void testFreightWagonLoad() {
        freightWagon.load();
        assertEquals(Status.LOADING, freightWagon.getStatus(), "Freight wagon should be in loading status.");
    }

    @Test
    public void testFreightWagonUnload() {
        freightWagon.load(); // Загружаем вагон
        freightWagon.unload();
        assertEquals(Status.UNLOADING, freightWagon.getStatus(), "Freight wagon should be in unloading status.");
    }

    @Test
    public void testFreightWagonSendToDestination() {
        freightWagon.sendToDestination();
        assertEquals(Status.EN_ROUTE, freightWagon.getStatus(), "Freight wagon should be en route.");
    }

    @Test
    public void testFreightWagonRepair() {
        freightWagon.repair();
        assertEquals(Status.IN_REPAIR, freightWagon.getStatus(), "Freight wagon should be in repair.");
    }

    @Test
    public void testPassengerWagonLoad() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            passengerWagon.load();
        });
        assertEquals("Операция загрузки не применима к пассажирскому вагону.", exception.getMessage());
    }

    @Test
    public void testPassengerWagonUnload() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            passengerWagon.unload();
        });
        assertEquals("Операция выгрузки не применима к пассажирскому вагону.", exception.getMessage());
    }

    @Test
    public void testPassengerWagonSendToDestination() {
        passengerWagon.sendToDestination();
        assertEquals(Status.EN_ROUTE, passengerWagon.getStatus(), "Passenger wagon should be en route.");
    }

    @Test
    public void testPassengerWagonService() {
        passengerWagon.service();
        assertEquals(Status.READY_TO_DEPART, passengerWagon.getStatus(), "Passenger wagon should be ready to depart after service.");
    }

    @Test
    public void testFragileFlagForFreightWagon() {
        assertTrue(freightWagon.isFragile(), "Freight wagon should be fragile.");
    }

    @Test
    public void testValuableFlagForFreightWagon() {
        assertTrue(freightWagon.isValuable(), "Freight wagon should be valuable.");
    }

    @Test
    public void testPassengerWagonCapacity() {
        assertEquals(100, ((PassengerWagon) passengerWagon).getPassengerCapacity(), "Passenger wagon should have a capacity of 100.");
    }
}
