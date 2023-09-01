package Bookingproject.Ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookingApp extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BookingApp"); // Setter tittel på vinduet
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/Bookingproject/BookingApp.fxml")))); // Sier at appen skal bruke "BookingApp.fxml"
        primaryStage.show();
        
    }
    
}
