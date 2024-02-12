package com.example.financialtracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

class FinancialTrackerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));
        primaryStage.setTitle("Financial Tracker");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
//glavna metoda aplikacije, prima 'stage' a to je glavni prozor app
    public static void main(String[] args) {
        launch(args); //pokrece JavaFX app
    }
}

//definira glavnu strukturu Javax app i postavlja korisnicko sucelje definirano u FXML datoteci