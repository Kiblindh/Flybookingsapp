package Bookingproject.BookingClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class BookingManager {
    private ArrayList<Flight> validFlights;

    public BookingManager(){
        this.validFlights = getValidFlights();
    }
    
    public static ArrayList<Flight> getValidFlights(){
        ArrayList<Location> validLocations = Location.ReadValidLocations();
        Flight flight1 = new Flight("20:00", "2023-04-13", 2000, validLocations.get(0), validLocations.get(1), 2000);
        Flight flight2 = new Flight("16:00", "2023-04-28", 2000, validLocations.get(0), validLocations.get(2), 2000);
        Flight flight3 = new Flight("13:00", "2023-04-16", 2000, validLocations.get(1), validLocations.get(2), 2000);
        Flight flight4 = new Flight("19:00", "2023-04-14", 2000, validLocations.get(2), validLocations.get(1), 2000);
        Flight flight5 = new Flight("20:00", "2023-04-10", 2000, validLocations.get(2), validLocations.get(0), 2000);
        Flight flight6 = new Flight("09:00", "2023-04-09", 2000, validLocations.get(1), validLocations.get(3), 2000);
        Flight flight7 = new Flight("23:00", "2023-04-06", 2000, validLocations.get(1), validLocations.get(5), 2000);

        ArrayList<Flight> validFlights = new ArrayList<>(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6, flight7));
        return validFlights;
    }

    public ArrayList<Location> getValidFrom(){
        ArrayList<Location> validFrom = new ArrayList<>();
        for (Flight flight : validFlights) {
            validFrom.add(flight.getOrigin());
        }
        return validFrom;
    }

    public ArrayList<Location> getValidTo(String origin){
        ArrayList<Location> validTo = new ArrayList<>();
        for (Flight flight : validFlights) {
            if(flight.getOrigin().getCity() == origin){
                validTo.add(flight.getDestination());
            }
        }
        return validTo;
    }

    public ArrayList<String> getValidDates(String originCity, String destinationCity){
        ArrayList<String> validDate = new ArrayList<>();
        for (Flight flight : validFlights) {
            if(flight.getOrigin().getCity() == originCity && flight.getDestination().getCity() == destinationCity){
                validDate.add(flight.getDate());
            }
        }
        return validDate;
    }

    public ArrayList<String> getValidTimes(String originCity, String destinationCity){
        ArrayList<String> validDate = this.getValidDates(originCity, destinationCity);
        ArrayList<String> validTimes = new ArrayList<>();
        for (Flight flight : validFlights) {
            for (String date : validDate) {
                if(flight.getDate().equals(date)){
                    validTimes.add(flight.getTime());
                }
            }
        }
        return validTimes;
    }

    public static void main(String[] args) {
        //Fra knapp - validFlights -> En liste med alle fly-objekter sin getOrigin()
        //To knapp - getValidTo(Oslo) -> Sjekker alle destinationer som har avganger fra Oslo
        //Dato knapp - getValidDates(Oslo, Bergen) -> Sjekker alle avganger fra Oslo til Bergen og legger til datoen deres til en liste med gyldige avganger
        //Tid knapp - getValidTimes(Oslo, Bergen) -> Iterer over gyldige datoer og alle fly-objekter, og legger til tidspunktene til de som samsvarer til listen
  
        BookingManager bookingManager1 = new BookingManager();
        ArrayList<String> validDatesOsloBergen = bookingManager1.getValidDates("Bergen", "Oslo");
        ArrayList<String> validTimeOsloBergen = bookingManager1.getValidTimes("Bergen", "Oslo");
        ArrayList<Location> validTo = bookingManager1.getValidTo("Bergen");
        System.out.println(bookingManager1.getValidFrom());
        System.out.println(validTo);
        System.out.println("\n");
        System.out.println(validDatesOsloBergen);
        System.out.println(validTimeOsloBergen);
        

    }

}
