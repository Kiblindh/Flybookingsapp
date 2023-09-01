package Bookingproject.BookingClasses;

import java.util.Comparator;

public class FlightsPriceComparator implements Comparator<Flight>{

    @Override
    public int compare(Flight flight1, Flight flight2) {
        return flight1.getTicketPrice() - flight2.getTicketPrice();
    }

    
}
