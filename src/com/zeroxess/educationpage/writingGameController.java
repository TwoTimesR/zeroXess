package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class writingGameController {
    private static int score = 0;
    private static int correctAnswers = 0;
    private int counter = 0;

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
       changeQuestion();
        System.out.println(getQuestions().get(0));
    }

    public List getQuestions() throws IOException{
        List<String> read = Files.readAllLines(Paths.get("src\\com\\zeroxess\\educationpage\\Questions.txt"));
        return read;
    }

    public  void  nextQuestion() throws IOException{
        counter++;
        System.out.println(counter);
        changeQuestion();
    }



public void changeQuestion() throws IOException{
        question.setText((String) getQuestions().get(counter));
}



    public List getAnswers() throws IOException{
        List<String> read = Files.readAllLines(Paths.get("src\\com\\zeroxess\\educationpage\\Answers"));
        return read;
    }


    public static int getCorrectAnswers() {
        return correctAnswers;
    }
    public void correctAnswer() throws IOException{
        if (getAnswers().get(counter).equals(Answer_field.getText())){
            Answer_field.setText("");
            Answer_field.setPromptText("");
            System.out.println("correct");
            correctAnswers++;
            score+=20;
            score_points.setText(String.valueOf(score));
            nextQuestion();
        } else{
            System.out.println("incorrect");
            Answer_field.setText("");
            Answer_field.setText("Wrong Answer");
        }
    }


}
