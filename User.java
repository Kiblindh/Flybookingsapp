package Bookingproject.BookingClasses;

import java.util.ArrayList;

public class User {
    private String username;
    private String email;
    private int balance;
    private String password;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public User(String username, String password, int balance, String email){
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmailUsername(String email) {
        if(email.contains("@") && email.contains(".") && email.contains("com")){
            String[] emailArray = email.split("@");
            this.username = emailArray[0];
            this.email = email;
        }
        else{
            throw new IllegalArgumentException("The email must be on the form 'username@gmail.com'");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public Booking getBooking(int i){
        return bookings.get(i);
    }

    public void addFlight(Flight flight){
        if(this.balance >= flight.getTicketPrice()){
            Booking booking = new Booking(this, flight);
            bookings.add(booking);
            flight.getBookedTickets().add(booking);
        }
        else{
            throw new IllegalArgumentException("The user doesn't have enough money to book the flight");
        }
    }

    public void removeBooking(Booking booking){ //The user won't be refunded when removing a booking
        booking.getFlight().getBookedTickets().remove(booking);
        bookings.remove(booking);
    }



    
}
