package Bookingproject.BookingClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LocationTest {

    @Test
    @DisplayName("The constructor makes a valid location")
    public void testConstructor(){
        Location lokasjon = new Location("Norway", "Oslo", "Gardermoen", "12:00");
        Assertions.assertEquals("Oslo", lokasjon.getCity(), "The location was created with the wrong city");
        Assertions.assertEquals("Gardermoen", lokasjon.getAirport(), "The location was created with the wrong city");
        Assertions.assertEquals("12:00", lokasjon.getTime(), "The location was created with the wrong city");
        Assertions.assertEquals("Norway", lokasjon.getCountry(), "The location was created with the wrong city");
    }
}
