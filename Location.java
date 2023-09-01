package Bookingproject.BookingClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Location {
    private String time;
    private String country;
    private String city;
    private String airport;

    public Location(String country, String city, String airport, String time){
        this.country = country;
        this.city = city;
        this.airport = airport;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getAirport() {
        return airport;
    }

    public String toString(){
        return "Country: " + this.country + ", City: " + this.city + ", Airport: " + this.airport;
    }

    public static ArrayList<Location> ReadValidLocations(){
        ArrayList<Location> locations = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/main/java/Bookingproject/BookingClasses/Locations.txt"), StandardCharsets.UTF_8)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] newLine = line.split(",");
                    Location lokasjon = new Location(newLine[0], newLine[1], newLine[2], newLine[3]);
                    locations.add(lokasjon);
                }
            } catch (IOException ex) {
                System.out.format("I/O error: %s%n", ex);
            }
        return locations;
    }
}
