package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class writingGameController {
    private static int score = 0;
    private static int correctAnswers = 0;
    private int counter = 0;
    private WritingGame game = new WritingGame("Guess the word");
    private Performance performance = new Performance();

    @FXML
    private Button button;

    public int getScore() {
        return score;
    }

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView image_view;
    @FXML
    Label score_points;

    @FXML
    Button back_button;
    @FXML
    Button next_button;
    @FXML
    Label question = new Label();
    @FXML
    TextField Answer_field = new TextField();


    public void initialize() throws IOException {
        System.out.println(counter);
        score_points.setText(String.valueOf(score));
        changeQuestion2();
        changePicture();
    }


    public void nextQuestion() throws IOException {
        counter++;
        System.out.println(counter);
        //changeQuestion();
        changePicture();
        if (counter == 9) {
            load();
        }
    }

    public void nextQuestion2() throws IOException {
        counter++;
        System.out.println(counter);
        changePicture();
        changeQuestion2();
        if (counter == 9) {
            load();
        }

    }


    public void changeQuestion2() throws IOException {
        //question.setText(objects.question.getQuestion());
        question.setText(game.createQuestions().get(counter));

    }


    public static int getCorrectAnswers() {
        return correctAnswers;
    }

//    public void correctAnswer() throws IOException {
//        if (getAnswers().get(counter).equals(Answer_field.getText())) {
//            Answer_field.setText("");
//            Answer_field.setPromptText("");
//            System.out.println("correct");
//            correctAnswers++;
//            score += 20;
//            score_points.setText(String.valueOf(score));
//            nextQuestion();
//        } else {
//            System.out.println("incorrect");
//            Answer_field.setText("");
//            Answer_field.setPromptText("Wrong answer");
//        }
//    }

    public void correctAnswer2() throws IOException {

        if (game.createAnswers().get(counter).equals(Answer_field.getText())) {
            Answer_field.setText("");
            Answer_field.setPromptText("");
            System.out.println("correct");
            correctAnswers++;
            nextQuestion2();
        } else {
            System.out.println("incorrect");
            Answer_field.setText("");
            Answer_field.setPromptText("Wrong answer");
        }
    }


    public void changePicture() throws IOException {
        ArrayList<FileInputStream> input = new ArrayList<>();
        input.add(new FileInputStream("src\\img\\apple.png"));
        input.add(new FileInputStream("src\\img\\bee.jpg"));
        input.add(new FileInputStream("src\\img\\japan.png"));
        input.add(new FileInputStream("src\\img\\hamburger.jpg"));
        input.add(new FileInputStream("src\\img\\lion.jpg"));
        input.add(new FileInputStream("src\\img\\spider.png"));
        input.add(new FileInputStream("src\\img\\car.png"));
        input.add(new FileInputStream("src\\img\\dancing.jpg"));
        input.add(new FileInputStream("src\\img\\java.png"));
        input.add(new FileInputStream("src\\img\\login.png"));

        Image img = new Image(input.get(counter));
        image_view.setImage(img);
    }

    public void load() throws IOException {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("endScreen.fxml"));
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }


}