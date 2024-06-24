package tests.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import app.Flights;

public class FlightsTest {

    @Test
    public void testGetCityName() {
        // Arrange
        Flights flight = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act
        String cityName = flight.getCityName();

        // Assert
        assertEquals("Test City", cityName);
    }

    @Test
    public void testGetCod() {
        // Arrange
        Flights flight = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act
        int cod = flight.getCod();

        // Assert
        assertEquals(123, cod);
    }

    @Test
    public void testGetDepartureTime() {
        // Arrange
        Flights flight = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act
        String departureTime = flight.getDepartureTime();

        // Assert
        assertEquals("19:30", departureTime);
    }

    @Test
    public void testGetArrivalTime() {
        // Arrange
        Flights flight = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act
        String arrivalTime = flight.getArrivalTime();

        // Assert
        assertEquals("20:30", arrivalTime);
    }

    @Test
    public void testGetPassengerCount() {
        // Arrange
        Flights flight = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act
        int passengerCount = flight.getPassengerCount();

        // Assert
        assertEquals(15, passengerCount);
    }

    @Test
    public void testEquals() {
        // Arrange
        Flights flight1 = new Flights("Test City", 123, "19:30", "20:30", 15);
        Flights flight2 = new Flights("Test City", 123, "19:30", "20:30", 15);

        // Act & Assert
        assertTrue(flight1.equals(flight2));
    }

    @Test
    public void testNotEquals() {
        // Arrange
        Flights flight1 = new Flights("Test City", 123, "19:30", "20:30", 15);
        Flights flight2 = new Flights("Different City", 456, "20:30", "21:30", 20);

        // Act & Assert
        assertFalse(flight1.equals(flight2));
    }
}