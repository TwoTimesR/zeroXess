package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class writingGameEndscreen {
    @FXML
    private AnchorPane anchorPane;

   @FXML
    private Label total_score;
   @FXML
    private Label correctAnswers;
   @FXML
    private ImageView img;

   public void  initialize() throws IOException {
       FileInputStream inputStream = new FileInputStream("src\\img\\frog.jpg");
       Image image = new Image(inputStream);
       img.setImage(image);
       writingGameController g = new writingGameController();
       total_score.setText(String.valueOf(g.getScore()));
       correctAnswers.setText(String.valueOf(writingGameController.getCorrectAnswers()));
   }
//   public void openHomePage() throws IOException{
//       Stage stage = (Stage) anchorPane.getScene().getWindow();
//       Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
//       Scene scene =  new Scene(root, 800 ,600);
//       stage.setScene(scene);
//       stage.show();
//   }




}
