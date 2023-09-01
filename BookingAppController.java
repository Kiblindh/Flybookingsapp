package Bookingproject.Ui;


import java.util.ArrayList;

import Bookingproject.BookingClasses.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;


public class BookingAppController {

    private ArrayList<Flight> flights = BookingManager.getValidFlights();
    private BookingManager bookingManager1 = new BookingManager();
    private Location origin;
    private Location destination;
    private String date;
    private String time;

    @FXML
    private MenuButton ToButton;
    
    @FXML
    private MenuButton FromButton;

    @FXML
    private MenuButton DateButton;

    @FXML
    private MenuButton TimeButton;

    @FXML
    private Button BookButton;

    @FXML
    private Label BookingText;

    @FXML
    private Label priceLabel;

    public void exit(){
        this.informationExitedMenu("Booking menu exited");
    }

    public void setOrigin(){
        ArrayList<Location> validFrom = bookingManager1.getValidFrom();
        for(int i = 0; i < validFrom.size(); i++){
            Location validLocation = validFrom.get(i);
            MenuItem item1 = new MenuItem("" + validLocation.getCity());
            this.FromButton.getItems().add(item1);
            item1.setOnAction(event -> {
                this.origin = validLocation;
                System.out.println(this.origin);
                    //Have to clear the fields to not get duplicate, and to reset the other fields every time you select another from
                this.ToButton.getItems().clear();
                this.DateButton.getItems().clear();
                this.TimeButton.getItems().clear();
                this.priceLabel.setText("");
                this.destination = null;
                this.date = null;
                this.time = null;
                this.setDestination();
                this.FromButton.setText(item1.getText());
            });
        }
        
    }
    
    public void setDestination(){
        ArrayList<Location> validTo = bookingManager1.getValidTo(this.origin.getCity());
        for(int i = 0; i < validTo.size(); i++){
            Location validLocation = validTo.get(i);
            MenuItem item1 = new MenuItem("" + validLocation.getCity());
            this.ToButton.getItems().add(item1);
            item1.setOnAction(event -> {
                this.destination = validLocation;
                System.out.println(this.destination);
                this.DateButton.getItems().clear();
                this.setDate();
                this.ToButton.setText(item1.getText());
            });
        }
    }

    public void setDate(){
        ArrayList<String> validDates = bookingManager1.getValidDates(this.origin.getCity(), this.destination.getCity());
        for(int i = 0; i < validDates.size(); i++){
            String validDate = validDates.get(i);
            MenuItem item1 = new MenuItem(validDate);
            this.DateButton.getItems().add(item1);
            item1.setOnAction(event -> {
                this.date = validDate;
                System.out.println(this.date);
                this.TimeButton.getItems().clear();
                this.setTime();
                this.DateButton.setText(item1.getText());
            });
        }
    }

    public void setTime(){
        ArrayList<String> validTimes = bookingManager1.getValidTimes(this.origin.getCity(), this.destination.getCity());
        for(int i = 0; i < validTimes.size(); i++){
            String validTime = validTimes.get(i);
            MenuItem item1 = new MenuItem(validTime);
            this.TimeButton.getItems().add(item1);
            item1.setOnAction(event -> {
                this.time = validTime;
                System.out.println(this.time);
                this.TimeButton.setText(item1.getText());
            });
        }
    }

    public void BookButton(){
        User defaultUser = new User("kiblindh", "random", 3000, "kiblindh@gmail.com");
        this.BookingText.setText("");
        if(this.ToButton != null || this.FromButton != null || this.DateButton != null || this.TimeButton != null){
            Flight flight1 = new Flight(this.time, this.date, 2000, this.origin, this.destination, 2000);
            Booking booking = new Booking(defaultUser, flight1);
            booking.writeBooking("booking.txt");
            this.priceLabel.setText("Price: " + Integer.toString(flight1.getTicketPrice()));
            this.BookingText.setText("Booking confirmed");
        }
    }

    public void initialize(){
        this.setOrigin();
    }

    public void informationExitedMenu(String message){
        Alert varsel = new Alert(AlertType.INFORMATION, message);
        varsel.showAndWait();
        System.exit(1);
    }


}

/*
 * Klikker på (From button) - skal gi alle destinasjoner som har en flygning fra seg
 * Klikker på (To button) - skal gi alle destinasjoner som har en flyavgang som går fra From til To
 * Klikker på (Date button) - skal gi alle datoer som har en flygning av den typen
 * Klikker på (Time button) - skal gi alle tider som har den flygningen på den gitte datoen
 * Klikker på (Book button) - skal skrive ut bookingen til fil hvis alle de øvrige buttoene er gyldige, ellers gi unvalid booking
 */
