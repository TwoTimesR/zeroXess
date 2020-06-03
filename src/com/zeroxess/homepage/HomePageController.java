package com.zeroxess.homepage;

import com.zeroxess.livestockpage.LiveStockController;
import com.zeroxess.user.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    GridPane homePane;

    public void openProfileManager() throws IOException {
        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/profilepage/profilepage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    public void openContacts() throws IOException {
        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/contactspage/contacts.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    public void openLiveStock() {
        Stage stage = (Stage) homePane.getScene().getWindow();
        new LiveStockController().start(stage);
    }

    public void openMarket() throws IOException {
        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/marketpage/marketpage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    public void openAppointmentsManager() throws IOException {
        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/medical/appointmentmanager.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    public void onLogOut() throws IOException {
        UserManager.getInstance().setLoggedInUser(null);

        Stage stage = (Stage) homePane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/loginpage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }
}
