package com.zeroxess.homepage;

import com.zeroxess.livestockpage.LiveStockController;
import com.zeroxess.medical.Appointment;
import com.zeroxess.medical.AppointmentController;
import com.zeroxess.user.UserManager;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML   GridPane homePane;
    @FXML   ListView<String> upcomingAppointmentsList;
    ObservableList<String> upcoming = FXCollections.observableArrayList();

    public HomePageController() {
        upcoming.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                upcomingAppointmentsList.setItems(upcoming);
            }
        });
    }


    public void initialize(){
        upcoming.setAll(UserManager.getInstance().getLoggedInUser().getUpcomingAppointments());

    }

    public void updateUpcomingAppointmentsList(ObservableList<String> upcomingAppointment){
         upcoming = upcomingAppointment;
    }

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
