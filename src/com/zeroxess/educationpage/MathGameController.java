package com.zeroxess.educationpage;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MathGameController {
    public Button normalPlayButton;
    public Button infinitePlayButton;
    public Button returnToStartButton;
    public Button normalDificulty;
    public Button hardDificulty;
    public Button returnToGameSelect;

    public Label number2;
    public Label mathSign1;
    public Label number1;
    public Label mathSign2;
    public Label number3;
    public TextField AnswerTextField;
    public Button checkAnswerButton;
    public Button nextQuestion;
    public Label scoreLabel;
    public Button QuitButton;
    public Label equalsSign;
    public Label scoreName;

    public Label questionLabel;
    public Label numberQuestion;
    public Button backToDificultySelect;
    
    public Button home_Page;
    public Label endTotal_score;
    public Label endScoreLabel;
    public Label farewellMessage;
    public Label endCorrectAnswers;
    public Label endCorectAnswersLabel;

    public Label titleLabel;
    public Label endIncorectAnswersLabel;
    public Label endIncorrectAnswers;
    int scoreAmountTemp;


    @FXML
    public BorderPane borderPane;
    @FXML
    public Button backButton;
    @FXML
    public Button startGame;

    boolean gameMode;
    boolean gameDifficulty;
    boolean correctAnswer;
    int questionNumber = 0;
    int correct = 0;
    int incorrect = 0;

    Performance performance;

    MathGameFactory mathGameFactory = new MathGameFactory();
    MathGame mathDigit1;
    MathGame mathDigit2;
    MathGame mathDigit3;
    MathGame mathSignOBJ1;
    MathGame mathSignOBJ2;






    @FXML
    public void onStartClicked(){
        onStartClickedDisabler();
    }

    @FXML
    public void returnToStart(){
        returnToStartDisabler();
    }
    @FXML
    public void returnToGameSelect(){
        returnToGameSelectDisabler();
    }

    @FXML
    public void normalPlay(){
        playSelected();
        this.gameMode = true;


    }
    @FXML
    public void infinitePlay(){
       playSelected();
       this.gameMode = false;


    }

    @FXML
    public void normalDificulty(){
        this.gameDifficulty = true;

        displayGameScreanNormal();
        createQuestion();

    }

    @FXML
    public void hardDificulty(){
        this.gameDifficulty = false;
        displayGameScreanHard();
        createQuestion();

    }

    public void createQuestion(){
        if (gameDifficulty){
            // normal Dificulty
            normalQuestionGen();
        }
        if (!gameDifficulty){
            hardQuestionGen();
        }
    }

    public void normalQuestionGen(){
        mathDigit1 = mathGameFactory.makeNumber();
        mathDigit2 = mathGameFactory.makeNumber();
        mathSignOBJ1 = mathGameFactory.makeMathSign();

        number1.setText(String.valueOf(mathDigit1.getDigit()));
        number2.setText(String.valueOf(mathDigit2.getDigit()));
        mathSign1.setText(mathSignOBJ1.getMathSign());
    }

    public void hardQuestionGen(){
        normalQuestionGen();
        mathDigit3 = mathGameFactory.makeNumber();
        mathSignOBJ2 = mathGameFactory.makeMathSign();

        number3.setText(String.valueOf(mathDigit3.getDigit()));
        mathSign2.setText(mathSignOBJ2.getMathSign());
    }

    @FXML
    public void onCheckAswerClicked() {
            checkAnswerButton.setVisible(false);
            nextQuestion.setVisible(true);

            int answer = getAnswer();
            checkAnswerMethod(answer);
    }



    public int getAnswer(){
        if (gameDifficulty){
            return anwserNormal();

        }
        else return answerHard();
    }

    public int anwserNormal(){
        int number1 = mathDigit1.getDigit();
        int number2 = mathDigit2.getDigit();
        if (mathSignOBJ1.getMathSign().equals("*")){
            return (number1 * number2);
        }
        if (mathSignOBJ1.getMathSign().equals("+")){
            return (number1 + number2);
        }
        else return (number1 - number2);
    }

    public int answerHard(){
        int number1 =mathDigit1.getDigit();
        int number2 =mathDigit2.getDigit();
        int number3 =mathDigit3.getDigit();
        int numberAfterMultiply;
        if(mathSignOBJ2.getMathSign().equals("*")){
            numberAfterMultiply = (number3 * number1);
            if (mathSignOBJ1.getMathSign().equals("*")){
                return (numberAfterMultiply * number2);
            }
            if (mathSignOBJ1.getMathSign().equals("+")){
                return (numberAfterMultiply + number2);
            }
            else return (numberAfterMultiply - number2);
        }
        if (mathSignOBJ1.getMathSign().equals("*")){
            numberAfterMultiply = (number1 * number2);
            if (mathSignOBJ2.getMathSign().equals("+")){
                return (number3 + numberAfterMultiply);
            }
            else return (number3 - numberAfterMultiply);
        }
        else return 999999;
    }

    public void checkAnswerMethod(int answer) {
            if (answer == Integer.parseInt(AnswerTextField.getText())) {
                AnswerTextField.setText("correct");
                AnswerTextField.setEditable(false);
                scoreAmountTemp = scoreAmountTemp + 10;
                performance.setScore(scoreAmountTemp);
                scoreLabel.setText(String.valueOf(performance.getScore()));
                correct ++;
                performance.setCorrectlyAnswered(correct);

                correctAnswer = true;
            }
            if (answer != Integer.parseInt(AnswerTextField.getText())) {
            AnswerTextField.setText("False");
            AnswerTextField.setEditable(false);
            scoreAmountTemp = scoreAmountTemp - 5;
            performance.setScore(scoreAmountTemp);
            scoreLabel.setText(String.valueOf(performance.getScore()));
            incorrect++;
            performance.setIncorrectlyAnswered(incorrect);

            correctAnswer = false;
        }

        }

    @FXML
    public void onnextQuestionClicked() {
        checkAnswerButton.setVisible(true);
        nextQuestion.setVisible(false);
        AnswerTextField.clear();
        AnswerTextField.setEditable(true);
        questionNumber ++;
        numberQuestion.setText(String.valueOf(questionNumber));
        if (gameMode) {
            if (questionNumber != 11) {
                createQuestion();
            }
            else onQuitButtonClicked();
        }
        else createQuestion();

    }

    @FXML
    public void onHomePageButtonClicked() throws IOException {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onQuitButtonClicked() {
        disableGameScreen();
        enableEndScreen();

    }

    @FXML
    public void onBackToDIficultySelect(){
        disableGameScreen();
    }


    @FXML
    public void returnToHomePage() throws IOException {
            Stage stage = (Stage) borderPane.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
            Scene scene =  new Scene(root, 800 ,600);
            stage.setScene(scene);
            stage.show();
    }

    public void onStartClickedDisabler(){
        normalPlayButton.setVisible(true);
        infinitePlayButton.setVisible(true);
        returnToStartButton.setVisible(true);
        startGame.setVisible(false);
        backButton.setVisible(false);
    }

    public void returnToStartDisabler(){
        normalPlayButton.setVisible(false);
        infinitePlayButton.setVisible(false);
        returnToStartButton.setVisible(false);
        startGame.setVisible(true);
        backButton.setVisible(true);
    }

    public void playSelected(){
        normalPlayButton.setVisible(false);
        infinitePlayButton.setVisible(false);
        returnToStartButton.setVisible(false);
        normalDificulty.setVisible(true);
        hardDificulty.setVisible(true);
        returnToGameSelect.setVisible(true);
    }

    public void returnToGameSelectDisabler(){
        normalDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        returnToGameSelect.setVisible(false);
        normalPlayButton.setVisible(true);
        infinitePlayButton.setVisible(true);
        returnToStartButton.setVisible(true);
    }

    public void displayGameScreanNormal(){
        number1.setVisible(true);
        number2.setVisible(true);
        mathSign1.setVisible(true);
        equalsSign.setVisible(true);
        scoreLabel.setVisible(true);
        scoreAmountTemp = 0;
        scoreLabel.setText(String.valueOf(scoreAmountTemp));
        scoreName.setVisible(true);
        questionLabel.setVisible(true);
        numberQuestion.setVisible(true);
        numberQuestion.setText("1");
        questionNumber = 1;
        correct = 0;
        incorrect = 0;
        backToDificultySelect.setVisible(true);
        AnswerTextField.setVisible(true);
        checkAnswerButton.setVisible(true);
        QuitButton.setVisible(true);
        normalDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        returnToGameSelect.setVisible(false);
        AnswerTextField.clear();

        performance = new Performance();
    }

    public void displayGameScreanHard(){
        displayGameScreanNormal();
        mathSign2.setVisible(true);
        number3.setVisible(true);
    }

    public void disableGameScreen(){
        number1.setVisible(false);
        number2.setVisible(false);
        mathSign1.setVisible(false);
        equalsSign.setVisible(false);
        scoreLabel.setVisible(false);
        scoreName.setVisible(false);
        questionLabel.setVisible(false);
        numberQuestion.setVisible(false);
        backToDificultySelect.setVisible(false);
        AnswerTextField.setVisible(false);
        checkAnswerButton.setVisible(false);
        nextQuestion.setVisible(false);
        QuitButton.setVisible(false);
        mathSign2.setVisible(false);
        number3.setVisible(false);
        normalDificulty.setVisible(true);
        hardDificulty.setVisible(true);
        returnToGameSelect.setVisible(true);
    }

    public void enableEndScreen(){
        farewellMessage.setVisible(true);
        home_Page.setVisible(true);
        endTotal_score.setVisible(true);
        endTotal_score.setText(String.valueOf(performance.getScore()));
        endScoreLabel.setVisible(true);
        endCorrectAnswers.setVisible(true);
        endCorrectAnswers.setText(String.valueOf(performance.getCorrectlyAnswered()));
        endIncorrectAnswers.setVisible(true);
        endIncorrectAnswers.setText(String.valueOf(performance.getIncorrectlyAnswered()));
        endCorectAnswersLabel.setVisible(true);
        endIncorectAnswersLabel.setVisible(true);
        normalDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        returnToGameSelect.setVisible(false);
        titleLabel.setVisible(false);

    }


}
