package tests.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.Airports;
import app.Flights;

public class AirportsTest {

    @Test
    public void testGetCity() {
        Airports airport = new Airports("Test City", "123");

        String city = airport.getCity();

        assertEquals("Test City", city);
    }

    @Test
    public void testGetAirportCod() {
        Airports airport = new Airports("Test City", "123");

        String cod = airport.getAirportCod();

        assertEquals("123", cod);
    }

    @Test
    public void testAddFlight() {
        
        Airports airport = new Airports("Test City", "123");
        Flights flight = new Flights("Destination City", 456, "19:30", "20:30", 15);

       
        try {
            airport.addFlight(flight);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        assertEquals(1, airport.getFlights().getQtd());
    }

    @Test
    public void testRemoveFlight() {
        
        Airports airport = new Airports("Test City", "123");
        Flights flight = new Flights("Destination City", 456, "19:30", "20:30", 15);

       
        try {
            airport.addFlight(flight);
            airport.removeFlight(flight);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Assert
        assertEquals(0, airport.getFlights().getQtd());
    }

    @Test
    public void testToString() {
        
        Airports airport = new Airports("Test City", "123");

        String str = airport.toString();

        assertTrue(str.contains("Test City") && str.contains("123"));
    }

    @Test
    public void testHashCode() {
        
        Airports airport1 = new Airports("Test City", "123");
        Airports airport2 = new Airports("Test City", "123");

        assertEquals(airport1.hashCode(), airport2.hashCode());
    }

    @Test
    public void testEquals() {
        
        Airports airport1 = new Airports("Test City", "123");
        Airports airport2 = new Airports("Test City", "123");

        assertTrue(airport1.equals(airport2));
    }

    @Test
    public void testClone() {
        
        Airports airport1 = new Airports("Test City", "123");

       
        Airports airport2 = (Airports) airport1.clone();

        assertNotNull(airport2);
        assertEquals(airport1, airport2);
    }
}