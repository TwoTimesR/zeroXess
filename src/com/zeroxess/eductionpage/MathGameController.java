package com.zeroxess.eductionpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MathGameController {
    public Button startButton;
    public Button backButton;
    public Button normalButton;
    public Button infinitePLay;
    public Button normailDificulty;
    public Button hardDificulty;
    public Button returnToStart;
    public Button returnToGameSelect;

    public Label number2Label;
    public Label equalsSign;
    public Label mathSgignOne;
    public Label number1Label;
    public Label mathSgigntwo;
    public Label number3Label;
    public TextField userAnswer;
    public Button checkAnswer;
    public Label scoreAmount;
    public Label asnwerDisplay;
    public Button nextQuestion;
    public Button endInfinite;

    @FXML
    private Button ending;
    @FXML
    private Label finalScore;

    private boolean gameSelect;
    private boolean infinite = false;
    private boolean dificultySelect;
    private int score;
    int gameLength = 1;


    MathGameFactory mathGameFactory = new MathGameFactory();

    @FXML
    private void startButtonClicked(){
        startButton.setVisible(false);
        backButton.setVisible(false);
        normalButton.setVisible(true);
        infinitePLay.setVisible(true);
        returnToStart.setVisible(true);
    }

    @FXML
    private  void   returnToStart(){
        startButton.setVisible(true);
        backButton.setVisible(true);
        normalButton.setVisible(false);
        infinitePLay.setVisible(false);
        returnToStart.setVisible(false);
    }

    @FXML
    private boolean chooseNormalPlay(){
        normalButton.setVisible(false);
        infinitePLay.setVisible(false);
        returnToGameSelect.setVisible(true);
        normailDificulty.setVisible(true);
        hardDificulty.setVisible(true);

        return gameSelect = true;
    }

    @FXML
    private boolean chooseInfinitePlay(){
        normalButton.setVisible(false);
        infinitePLay.setVisible(false);
        returnToGameSelect.setVisible(true);
        normailDificulty.setVisible(true);
        hardDificulty.setVisible(true);

        return gameSelect = false;
    }

    @FXML
    private void returnToGameSelect(){
        normalButton.setVisible(true);
        infinitePLay.setVisible(true);
        returnToGameSelect.setVisible(false);
        normailDificulty.setVisible(false);
        hardDificulty.setVisible(false);
    }


    @FXML
    private void chooseNormalDificulty(){
        normailDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        number1Label.setVisible(true);
        number2Label.setVisible(true);
        equalsSign.setVisible(true);
        mathSgignOne.setVisible(true);
        userAnswer.setVisible(true);
        checkAnswer.setVisible(true);
        scoreAmount.setVisible(true);
        resetScore();

        dificultySelect = true;

        createMath();
    }

    @FXML
    private void choosehardDificulty(){
        normailDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        number1Label.setVisible(true);
        number2Label.setVisible(true);
        equalsSign.setVisible(true);
        mathSgignOne.setVisible(true);
        userAnswer.setVisible(true);
        checkAnswer.setVisible(true);
        scoreAmount.setVisible(true);
        mathSgigntwo.setVisible(true);
        mathSgigntwo.setVisible(true);
        number3Label.setVisible(true);
        resetScore();


        dificultySelect = false;
        createMath();
    }

    private void createMath() {
            if (dificultySelect){
                runNormal();
            }
            if (!dificultySelect){
                runHard();
            }

    }

    private void runNormal(){
            number1Label.setText(String.valueOf(mathGameFactory.randomNumbers()));
            number2Label.setText(String.valueOf(mathGameFactory.randomNumbers()));
            mathSgignOne.setText(String.valueOf(mathGameFactory.randomMathSign()));
            scoreAmount.setText(String.valueOf(score));
    }

    private void runHard(){
        number1Label.setText(String.valueOf(mathGameFactory.randomNumbers()));
        number2Label.setText(String.valueOf(mathGameFactory.randomNumbers()));
        number3Label.setText(String.valueOf(mathGameFactory.randomNumbers()));
        mathSgignOne.setText(String.valueOf(mathGameFactory.randomMathSign()));
        mathSgigntwo.setText(String.valueOf(mathGameFactory.randomMathSign()));
        scoreAmount.setText(String.valueOf(score));
    }
    @FXML
    private void checkAnswer(){
        if (gameSelect = true){
            while (gameLength < 10){
                runScoreUpdate( runCheck());
                gameLength ++;
            }
            if (gameLength >10){
                runEndScrean();
            }
        }
        if (gameSelect = false){
            while (!infinite){
                runScoreUpdate(runCheck());
            }
            if (infinite){
                runEndScrean();
            }
        }
    }

    private boolean runCheck(){
        if (dificultySelect){
            return runCheckNormal();
        }
        else {
            return runCheckHard();
        }
    }

    private boolean runCheckNormal(){
        String number1LabelText = number1Label.getText();
        String number2LabelText = number2Label.getText();
        int number1 = Integer.parseInt(number1LabelText);
        int number2 = Integer.parseInt(number2LabelText);
        int sign1 = Integer.parseInt(mathSgignOne.getText());
        int answer = number1 + sign1 + number2;
        asnwerDisplay.setVisible(true);
        nextQuestion.setVisible(true);
        asnwerDisplay.setText(String.valueOf(answer));
        checkAnswer.setVisible(false);
        if (Integer.parseInt(userAnswer.getText()) == answer){
            return true;
        }
        else return false;
    }

    private boolean runCheckHard(){
        String number1LabelText = number1Label.getText();
        String number2LabelText = number2Label.getText();
        String number3LabelText = number3Label.getText();
        int number1 = Integer.parseInt(number1LabelText);
        int number2 = Integer.parseInt(number2LabelText);
        int number3 = Integer.parseInt(number3LabelText);
        int sign1 = Integer.parseInt(mathSgignOne.getText());
        int sign2 = Integer.parseInt(mathSgigntwo.getText());
        int answer = number3 + sign2 + number1 + sign1 + number2;
        asnwerDisplay.setVisible(true);
        nextQuestion.setVisible(true);
        asnwerDisplay.setText(String.valueOf(answer));
        checkAnswer.setVisible(false);
        if (Integer.parseInt(userAnswer.getText()) == answer){
            return true;
        }
        else return false;
    }


    private void runScoreUpdate(boolean correct){
        if (correct){
            score =+10;
        }
        else{
            score =-5;
        }
        scoreAmount.setText(String.valueOf(score));
    }

    private void resetScore(){
        score = 0;
        gameLength = 1;
    }

    @FXML
    private void nextQuestion(){
        nextQuestion.setVisible(false);
        checkAnswer.setVisible(true);
        asnwerDisplay.setVisible(false);
        createMath();

    }

    @FXML
    private void endInfiniteButton(){
        infinite = true;
    }

    private void runEndScrean(){
        normailDificulty.setVisible(false);
        hardDificulty.setVisible(false);
        number1Label.setVisible(false);
        number2Label.setVisible(false);
        equalsSign.setVisible(false);
        mathSgignOne.setVisible(false);
        userAnswer.setVisible(false);
        checkAnswer.setVisible(false);
        scoreAmount.setVisible(false);
        mathSgigntwo.setVisible(false);
        mathSgigntwo.setVisible(false);
        number3Label.setVisible(false);
        ending.setVisible(true);
        finalScore.setVisible(true);
        finalScore.setText(String.valueOf(score));

    }

    @FXML
    private void endButtonClicked(){
        resetScore();
        startButton.setVisible(true);
        backButton.setVisible(true);


    }
}

