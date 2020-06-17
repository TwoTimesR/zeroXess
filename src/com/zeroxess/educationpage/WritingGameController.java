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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class WritingGameController {
    private int score = 0;
    private int correctAnswers = 0;
    private int counter = 0;
    private final WritingGame game = new WritingGame("Guess the word");

    @FXML
    private Label end_answers;

    @FXML
    private Label end_score;

    @FXML
    private Label total_score_text;

    @FXML
    private Label total_answers_text;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView image_view;

    @FXML
    private Label score_points;

    @FXML
    private Button check_button;

    @FXML
    private Label score_text;

    @FXML
    private Button home_button;

    @FXML
    private Button next_button;

    @FXML
    private Label question;

    @FXML
    private TextField Answer_field;

    private void writingGameSetup() {
        SingularQuestion question0 = new SingularQuestion("1.What is the name of this fruit?", "apple");
        SingularQuestion question1 = new SingularQuestion("2.What is the name of this insect?", "bee");
        SingularQuestion question2 = new SingularQuestion("3.Which country does this flag belong to?", "japan");
        SingularQuestion question3 = new SingularQuestion("4.What is the name of this food?", "hamburger");
        SingularQuestion question4 = new SingularQuestion("5.What is the name of this animal?", "lion");
        SingularQuestion question5 = new SingularQuestion("6.What is the name of this insect?", "spider");
        SingularQuestion question6 = new SingularQuestion("7.What do you call this vehicle?", "car");
        SingularQuestion question7 = new SingularQuestion("8.What are they doing?", "dancing");
        SingularQuestion question8 = new SingularQuestion("9.What programming language is this?", "java");
        game.addSingularQuestion(question0);
        game.addSingularQuestion(question1);
        game.addSingularQuestion(question2);
        game.addSingularQuestion(question3);
        game.addSingularQuestion(question4);
        game.addSingularQuestion(question5);
        game.addSingularQuestion(question6);
        game.addSingularQuestion(question7);
        game.addSingularQuestion(question8);
    }

    public void initialize() throws IOException {
        writingGameSetup();
        System.out.println(counter);
        score_points.setText(String.valueOf(score));
        changeQuestion();
        changePicture();
    }


    public void nextQuestion() throws IOException {
        counter++;
        System.out.println(counter);
        if (counter == game.getSingularQuestions().size()) {
            endingScreen();
        }
        else {
            changePicture();
            changeQuestion();
        }
    }

    public void changeQuestion() {
        question.setText(game.getSingularQuestions().get(counter).getQuestion());
    }

    public void correctAnswer() throws IOException {
        /*
        hier maak ik gebruik van de singular question class die standaard bij elk correct vraag 20 punten geeft,
        als ik in writinggame class een vraag zelf punten als waarden geef, dan word dat opgeteld.
        */
        if (game.getSingularQuestions().get(counter).getSingularAnswer().getCorrectAnswer().equals(Answer_field.getText())) {
            score += game.getSingularQuestions().get(counter).getPoints();
            score_points.setText(String.valueOf(score));
            System.out.println("score" + " " + score);
            Answer_field.setText("");
            Answer_field.setPromptText("");
            System.out.println("correct");
            correctAnswers++;
            nextQuestion();
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
        input.add(new FileInputStream("src\\img\\frog.jpg"));

        Image img = new Image(input.get(counter));
        image_view.setImage(img);
    }

    public void endingScreen() throws FileNotFoundException {
        next_button.setVisible(false);
        Answer_field.setVisible(false);
        check_button.setVisible(false);
        score_points.setVisible(false);
        score_text.setVisible(false);
        end_score.setText(String.valueOf(score));
        end_answers.setText(String.valueOf(correctAnswers));
        end_score.setVisible(true);
        end_answers.setVisible(true);
        total_score_text.setVisible(true);
        total_answers_text.setVisible(true);
        question.setText("Thank you for playing !");
        home_button.setVisible(true);
        question.setLayoutX(240);
        endingPicture();
    }

    public void endingPicture() throws FileNotFoundException {
        Image img = new Image(new FileInputStream("src\\img\\frog.jpg"));
        image_view.setImage(img);
        image_view.setFitHeight(239);
        image_view.setFitWidth(368);
    }

    public void homepage() throws IOException {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }
}
