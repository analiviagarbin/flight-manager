package tests.app;

import app.Airports;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportsTest {

    @Test
    public void testGetCity() {
        Airports airport = new Airports("New York", "123");
        assertEquals("New York", airport.getCity());
    }

    @Test
    public void testGetAirportCod() {
        Airports airport = new Airports("New York", "123");
        assertEquals("123", airport.getAirportCod());
    }

    @Test
    public void testAddFlight() {
        Airports airport = new Airports("New York", "123");
        try {
            airport.addFlight("Los Angeles", 456);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        assertEquals(1, airport.getFlights().getQtd());
    }

    @Test
    public void testRemoveFlight() {
        Airports airport = new Airports("New York", "123");
        try {
            airport.addFlight("Los Angeles", 456);
            airport.removeFlight("Los Angeles", 456);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        assertEquals(0, airport.getFlights().getQtd());
    }

    @Test
    public void testToString() {
        Airports airport = new Airports("New York", "123");
        String expected = "Cidade: New York Código do aeroporto 123 Voos deste aeroporto: ";
        assertEquals(expected, airport.toString());
    }

    @Test
    public void testEquals() {
        Airports airport1 = new Airports("New York", "123");
        Airports airport2 = new Airports("New York", "123");
        assertTrue(airport1.equals(airport2));
    }

    @Test
    public void testClone() {
        Airports airport1 = new Airports("New York", "123");
        Airports airport2 = (Airports) airport1.clone();
        assertNotSame(airport1, airport2);
        assertEquals(airport1, airport2);
    }
}