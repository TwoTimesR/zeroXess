package com.zeroxess.profilepage;

import com.zeroxess.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ProfilePageController {

    @FXML
    BorderPane pane;

    @FXML
    private TextField Last_Name;

    @FXML
    private TextField Email;

    @FXML
    private TextField Phone;

    @FXML
    private TextField Location;

    @FXML
    private TextField First_Name;

    @FXML
    private Button Back_button;

    @FXML
    private Button Save_button;

    @FXML
    private Button Show_Button;

    // Zodra de savebutton is gedrukt wordt alle informatie opgeslagen.
    public void SaveButtonClicked() {
        Save_button.setOnAction(actionEvent -> writeTxtFile());
    }

    // zodra de showbutton is gedrukt worden de opgeslagen gegevens vertoont.
    public void ShowButtonClicked() {
        Show_Button.setOnAction(actionEvent -> {
            try {
                showTxtFile();
                getInformatieTxt();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    // Deze methode schrijft de informatie van de textfields naar een .txt file.
    public void writeTxtFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(".\\ProfileInfo.txt"));
            writer.write(First_Name.getText());
            writer.newLine();
            writer.write(Last_Name.getText());
            writer.newLine();
            writer.write(Email.getText());
            writer.newLine();
            writer.write(Phone.getText());
            writer.newLine();
            writer.write(Location.getText());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // deze methode leest alle lines van de textfile die in een list zijn opgeslagen een toont het aan.
    public void showTxtFile() throws IOException {
        List<String> ReadTxtFile = Files.readAllLines(Paths.get("ProfileInfo.txt"));
        First_Name.setText(ReadTxtFile.get(0));
        Last_Name.setText(ReadTxtFile.get(1));
        Email.setText(ReadTxtFile.get(2));
        Phone.setText(ReadTxtFile.get(3));
        Location.setText(ReadTxtFile.get(4));
    }

    public void goToHomePage() throws IOException {
        Utilities.openHomeScreen(pane);
    }

    // deze methode print de gegevens van het profiel op het commandline
    public List getInformatieTxt() throws IOException {
        List<String> ReadTxtFile = Files.readAllLines(Paths.get("ProfileInfo.txt"));
        for (String x :
                ReadTxtFile) {
            System.out.println(x);
        }
        return ReadTxtFile;
    }
}


