package Bookingproject.BookingClasses;

import java.time.LocalDate;
import java.util.ArrayList;

public class Flight {
    private String time;
    private LocalDate date;
    private int ticketPrice;
    private Location origin;
    private Location destination;
    private int capacity = 0;
    private ArrayList<Booking> bookedTickets = new ArrayList<>();
    private ArrayList<Location> validLocation = Location.ReadValidLocations();

    public Flight(String time, String date, int ticketPrice, Location origin, Location destination, int capacity){
        setOrigin(origin);
        setDestination(destination);
        if(!this.determineValidLocations()){
            throw new IllegalArgumentException("The origin and location is not valid");
        }
        setTicketPrice(ticketPrice);
        setDate(date);
        setTime(time);
        setCapacity(capacity);
    }

    public String getDate(){
        return this.date.toString();
    }

    public boolean determineValidLocations(){
        int count = 0;
        for (Location location : this.validLocation) {
            boolean statement1 = location.getCity().equals(origin.getCity()) && location.getCountry().equals(origin.getCountry()) && location.getAirport().equals(origin.getAirport()) && location.getTime().equals(origin.getTime());
            boolean statement2 = location.getCity().equals(destination.getCity()) && location.getCountry().equals(destination.getCountry()) && location.getAirport().equals(destination.getAirport()) && location.getTime().equals(destination.getTime());
            if(statement1){
                count += 1;
            }
            if(statement2){
                count += 1;
            }
        }
        if(count == 2){
            return true;
        }
        return false;
    }

    public String getTime(){
        return this.time;
    }

    public ArrayList<Booking> getBookedTickets(){
        return bookedTickets;
    }

    public int getAmountOfBookedTickets(){
        return this.bookedTickets.size();
    }

    public Location getOrigin(){
        return this.origin;
    }

    public Location getDestination(){
        return this.destination;
    }

    public void setTicketPrice(int ticketPrice){
        if(ticketPrice < 0){
            throw new IllegalArgumentException("The ticketprice can't be negative");
        }
        this.ticketPrice = ticketPrice;
    }

    public void setOrigin(Location origin){
        this.origin = origin;
    }

    public void setDestination(Location destination){
        this.destination = destination;
    }

    public void setCapacity(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("The plane must have a positive capacity");
        }
        this.capacity = capacity;
    }

    public void setDate(String date){
        LocalDate dato = LocalDate.parse(date);
        LocalDate currentDate = LocalDate.parse("2023-03-25");
        if(dato.compareTo(currentDate) == 0 || dato.compareTo(currentDate) == 1){
            this.date = dato;
        }
        else{
            throw new IllegalArgumentException("The date has to be after the 2023-03-25");
        }
    }
    public void setTime(String time){
        if(!time.matches("(?:[0-1][0-9]|2[0-4]):[0-5]\\d")){
            throw new IllegalArgumentException("The time you entered was not valid");
        }
        this.time = time;
    }
    /*
    public String toString(){
        return  "From: \n" + this.origin + "\nTo:\nDestination: " + this.destination + "\nDate: " + this.date.toString() + "\nTime: " + this.time + "\nCapacity: " + this.capacity;
    }*/

    public int getTicketPrice(){
        return this.ticketPrice;
    }

    public static void main(String[] args) {
        //ArrayList<Location> validLocation = Location.ReadValidLocations();
        //System.out.println(validLocation.size());
        Location Oslo = new Location("Norway", "Oslo", "Gardermoen", "15:30");
        Location Bergen = new Location("Norway", "Bergen", "Flesland", "15:30");
        Flight flight1 = new Flight("12:00", "2023-03-26", 2000, Bergen, Oslo, 2000);
        System.out.println(flight1);
        Flight flight2 = new Flight("12:00", "2023-03-26", 3000, Oslo, Bergen, 2000);
        Flight flight3 = new Flight("14:00", "2023-03-26", 2500, Oslo, Bergen, 2000);
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        FlightsPriceComparator comparator = new FlightsPriceComparator();
        User kim = new User("kiblindh", "kims", 4000, "kiblindh@ntnu.no");
        //Collections.sort(flights, comparator);
        Booking test = new Booking(kim, flight3);
        System.out.println(flights);
        test.CompareFlightsPrice(flights);
        System.out.println(flights);
        
        /*User Kim = new User("Kiblindh", "Kims", 3000, "kiblindh@gmail.com");
        Booking booking1 = new Booking(Kim, flight1);
        System.out.println(flight1.getBookedTickets());
        System.out.println(Kim.getBalance());
        System.out.println(booking1);
        //booking1.createFile("Test.txt");
        //booking1.writeBooking("Test.txt");*/
    }
}
