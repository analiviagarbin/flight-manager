package tests.app;

import app.Flights;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightsTest {

    @Test
    public void testGetCityName() {
        Flights flight = new Flights("New York", 123);
        assertEquals("New York", flight.getCityName());
    }

    @Test
    public void testGetCod() {
        Flights flight = new Flights("New York", 123);
        assertEquals(123, flight.getCod());
    }

    @Test
    public void testEquals() {
        Flights flight1 = new Flights("New York", 123);
        Flights flight2 = new Flights("New York", 123);
        assertTrue(flight1.equals(flight2));
    }

    @Test
    public void testToString() {
        Flights flight = new Flights("New York", 123);
        String expected = "(Cidade de destino: New York Codigo do voo: 123)";
        assertEquals(expected, flight.toString());
    }
}