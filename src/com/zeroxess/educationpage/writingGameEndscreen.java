package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public class writingGameEndscreen {

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


}
