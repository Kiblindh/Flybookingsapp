package Bookingproject.BookingClasses;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FlightTest {
    ArrayList<Location> validLocations = Location.ReadValidLocations();
    @Test
    @DisplayName("Tries to created flight with invalid destination or origin, or both invalid origin and destination")
    public void testConstructor(){
        ArrayList<Location> validLocations = Location.ReadValidLocations();
        Location Ålesund = new Location("Norway", "Ålesund", "Vigra", "12:00");
        Location Trondheim = new Location("Norway", "Trondheim", "Værnes", "13:00");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Flight("13:00", "2023-04-02", 2000, validLocations.get(0), Ålesund, 2000);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Flight("13:00", "2023-04-02", 2000, Ålesund, validLocations.get(0), 2000);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Flight("13:00", "2023-04-02", 2000, Ålesund, Trondheim, 2000);
        });
    }
    @Test
    @DisplayName("Tries to set ticketPrice to negative")
    public void testSetTicketPrice(){
        Flight flight = new Flight("13:00", "2023-04-02", 2000, validLocations.get(0), validLocations.get(1), 2000);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            flight.setTicketPrice(-1000);
        });
    }
    
    @Test
    @DisplayName("Tries to create flight from and to the same location")
    public void testFlightDestinationOrigin(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Flight("13:00", "2023-04-02", 2000, validLocations.get(1), validLocations.get(1), 2000);
        });
    }
}
