package Bookingproject.BookingClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Booking {
    private User user;
    private Flight flight;
    private int bookingID = 0;
    
    public Booking(User user, Flight flight){
        if(user.getBalance() >= flight.getTicketPrice()){
            this.user = user;
            this.flight = flight;
            this.bookingID = this.flight.getBookedTickets().size();
            flight.getBookedTickets().add(this);
            user.setBalance(user.getBalance() - flight.getTicketPrice());
            //this.validBooking();
        }
        else{
            throw new IllegalArgumentException("The user don't have enough money to book the flight");
        }
    }

    public Flight getFlight(){
        return flight;
    }

    public User getUser(){
        return user;
    }

    public int getBookingID(){
        return bookingID;
    }

    public String toString(){
        return "BookingID: " + getBookingID() + "\nUser: " + getUser() + "\nFlight: " + getFlight();
    }

    public void createFile(String textFile){
        try{
            File bookingFile = new File(textFile);
            if(bookingFile.createNewFile()){
                System.out.println("The file is created");
            }
            else{
                System.out.println("The file already exists");
            }
        }
        catch(IOException fileException){
            System.out.println("An error occured");
            fileException.printStackTrace();
        }
    }
    public void writeBooking(String textFile){
        try{
            FileWriter bookingWriter = new FileWriter(textFile);
            bookingWriter.write("Username: " + user.getUsername());
            bookingWriter.write("\nEmail: " + user.getEmail());
            bookingWriter.write("\nPrice of ticket: " + flight.getTicketPrice());
            bookingWriter.write("\nBalance after booking: " + user.getBalance());
            bookingWriter.write("\nFrom: " +flight.getOrigin().getCountry() + ", " + flight.getOrigin().getCity() + ", " + flight.getOrigin().getAirport());
            bookingWriter.write("\nTo: " + flight.getDestination().getCountry() + ", " + flight.getDestination().getCity() + ", " + flight.getDestination().getAirport());
            bookingWriter.write("\nDate: " + flight.getDate() + ", Time: " + flight.getTime());
            bookingWriter.close();
            System.out.println("It's been written to the file");
        }
        catch(IOException failedToWrite){
            System.out.println("An error occured");
            failedToWrite.printStackTrace();
        }
    }

    public ArrayList<Flight> CompareFlightsPrice(ArrayList<Flight> flights){
        FlightsPriceComparator comparator = new FlightsPriceComparator();
        Collections.sort(flights, comparator);
        return flights;
    }
    /*
    public boolean validBooking(){
        for (Flight flight : BookingManager.getValidFlights()) {
            if(flight.getTime().equals(this.flight.getTime()) && flight.getDate().equals(this.flight.getDate())){
                if(flight.getOrigin().equals(this.flight.getOrigin()) && flight.getDestination().equals(this.flight.getDestination())){
                    return true;
                }
            }
        }
        throw new IllegalArgumentException("The booking is not valid");
    }
    */


}
