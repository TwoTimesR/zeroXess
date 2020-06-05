package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class MathGameEndScreenController {
    public Label total_score;
    public Label correctAnswers;
    public Button home_Page;
    public AnchorPane anchorpane;
    public ImageView img;

    public void  initialize() throws IOException {
        FileInputStream inputStream = new FileInputStream("src\\img\\frog.jpg");
        Image image = new Image(inputStream);
        img.setImage(image);
        MathGameController mathGameController = new MathGameController();
        correctAnswers.setText(String.valueOf(mathGameController.getCorrectAnswers()));
        total_score.setText(String.valueOf(mathGameController.getScore()));
    }


    @FXML
    private void onHomePageButtonClicked() throws IOException {
        Stage stage = (javafx.stage.Stage) anchorpane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
}
