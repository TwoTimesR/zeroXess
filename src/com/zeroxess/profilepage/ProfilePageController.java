package com.zeroxess.profilepage;

import com.zeroxess.Utilities;
import com.zeroxess.user.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Path;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ProfilePageController {

    @FXML BorderPane pane;
    @FXML private TextField Last_Name;
    @FXML private TextField Email;
    @FXML private TextField Phone;
    @FXML private TextField Location;
    @FXML private TextField First_Name;
    @FXML private Button Save_button;

// wnr het voor het profielscherm gekozen wordt, laden alle gegevens en kan de gebruiker het weer aanpassen en opslaan.
    public void initialize() throws IOException {
        showTxtFile();
    }
    // Zodra de savebutton is gedrukt wordt alle informatie opgeslagen.
    public void SaveButtonClicked() {
        Save_button.setOnAction(actionEvent -> changeUserInfo());
    }

    // Deze methode schrijft de informatie van de textfields naar de user class
    public void changeUserInfo() {
        UserManager.getInstance().getLoggedInUser().getUserProfile().setFirstName(First_Name.getText());
        UserManager.getInstance().getLoggedInUser().getUserProfile().setLastName(Last_Name.getText());
        UserManager.getInstance().getLoggedInUser().getUserProfile().setEmail(Email.getText());
        UserManager.getInstance().getLoggedInUser().getUserProfile().setPhoneNumber(Phone.getText());
        UserManager.getInstance().getLoggedInUser().getUserProfile().setLocation(Location.getText());
    }

    // deze methode leest de persoonsgegevens uit de user class.
    public void showTxtFile() throws IOException {
        First_Name.setText(UserManager.getInstance().getLoggedInUser().getUserProfile().getFirstName());
        Last_Name.setText(UserManager.getInstance().getLoggedInUser().getUserProfile().getLastName());
        Email.setText(UserManager.getInstance().getLoggedInUser().getUserProfile().getEmail());
        Phone.setText(UserManager.getInstance().getLoggedInUser().getUserProfile().getPhoneNumber());
        Location.setText(UserManager.getInstance().getLoggedInUser().getUserProfile().getLocation());
    }

    public void goToHomePage() throws IOException {
        Utilities.openHomeScreen(pane);
    }
}


