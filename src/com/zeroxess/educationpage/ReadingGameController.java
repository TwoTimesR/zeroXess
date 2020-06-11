package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ReadingGameController {
    private final ReadingGame readingGame = new ReadingGame("The Adventure's of Jim");

    @FXML
    private Pane pane;

    @FXML
    private TextArea reading_text;

    @FXML
    private TextArea question_text;

    @FXML
    private TextArea mc_answer_0;

    @FXML
    private TextArea mc_answer_1;

    @FXML
    private TextArea mc_answer_2;

    @FXML
    private TextArea mc_answer_3;

    @FXML
    private CheckBox mc_answer_box_0;

    @FXML
    private CheckBox mc_answer_box_1;

    @FXML
    private CheckBox mc_answer_box_2;

    @FXML
    private CheckBox mc_answer_box_3;

    @FXML
    private Button previous_question;

    @FXML
    private Button confirm_answer;

    @FXML
    private Button next_question;

    @FXML
    private Label score;

    @FXML
    private Label score_text;

    @FXML
    private Button back;

    private Integer currentQuestion = 0;
    private final ArrayList<MultipleChoiceAnswer> selectedAnswers = new ArrayList<>();
    private Boolean gameCompleted = false;

    private void readingGameSetUp() {
        readingGame.setReadingText(
                "Jim was born in a far away land called Avalon.\n" +
                "He was a simple man, managing a dock in a small coastal village\n" +
                "One day Jim saw a strange boat a long distance away from the docks\n" +
                ""
        );

        MultipleChoiceQuestion mcq_0 = new MultipleChoiceQuestion("Where was Jim born?");
        MultipleChoiceAnswer mca_0_0 = new MultipleChoiceAnswer("Escalia", false);
        MultipleChoiceAnswer mca_0_1 = new MultipleChoiceAnswer("Avalon", true);
        MultipleChoiceAnswer mca_0_2 = new MultipleChoiceAnswer("New Jersey", false);
        MultipleChoiceAnswer mca_0_3 = new MultipleChoiceAnswer("The Southern Isle's", false);
        mcq_0.addMultipleChoiceAnswer(mca_0_0);
        mcq_0.addMultipleChoiceAnswer(mca_0_1);
        mcq_0.addMultipleChoiceAnswer(mca_0_2);
        mcq_0.addMultipleChoiceAnswer(mca_0_3);

        MultipleChoiceQuestion mcq_1 = new MultipleChoiceQuestion("What does Jim mainly do?");
        MultipleChoiceAnswer mca_1_0 = new MultipleChoiceAnswer("Sell fruit on the market", false);
        MultipleChoiceAnswer mca_1_1 = new MultipleChoiceAnswer("Bureaucracy", false);
        MultipleChoiceAnswer mca_1_2 = new MultipleChoiceAnswer("Manage a dock", true);
        MultipleChoiceAnswer mca_1_3 = new MultipleChoiceAnswer("Explore the world", false);
        mcq_1.addMultipleChoiceAnswer(mca_1_0);
        mcq_1.addMultipleChoiceAnswer(mca_1_1);
        mcq_1.addMultipleChoiceAnswer(mca_1_2);
        mcq_1.addMultipleChoiceAnswer(mca_1_3);

        MultipleChoiceQuestion mcq_2 = new MultipleChoiceQuestion("What did Jim see a long distance from the docks?");
        MultipleChoiceAnswer mca_2_0 = new MultipleChoiceAnswer("A strange boat", true);
        MultipleChoiceAnswer mca_2_1 = new MultipleChoiceAnswer("A sea dragon", false);
        MultipleChoiceAnswer mca_2_2 = new MultipleChoiceAnswer("A giant whale", false);
        MultipleChoiceAnswer mca_2_3 = new MultipleChoiceAnswer("A mermaid", false);
        mcq_2.addMultipleChoiceAnswer(mca_2_0);
        mcq_2.addMultipleChoiceAnswer(mca_2_1);
        mcq_2.addMultipleChoiceAnswer(mca_2_2);
        mcq_2.addMultipleChoiceAnswer(mca_2_3);

        readingGame.addMultipleChoiceQuestion(mcq_0);
        readingGame.addMultipleChoiceQuestion(mcq_1);
        readingGame.addMultipleChoiceQuestion(mcq_2);
    }

    public void initialize() {
        readingGameSetUp();
        displayReadingText();
        displayQuestionAndAnswers();
        displayScore();
    }

    public void displayReadingText() {
        reading_text.setText(readingGame.getReadingText());
        System.out.println("Reading text has been displayed");
    }

    private void displayQuestion() {
        question_text.setText(readingGame.getMultipleChoiceQuestions().get(currentQuestion).getQuestion());
        System.out.println("Question has been displayed");
    }

    private void displayAnswer0() {
        mc_answer_0.setText(getDisplayAnswerText(0));
        System.out.println("Answer 0 has been displayed");
    }

    private void displayAnswer1() {
        mc_answer_1.setText(getDisplayAnswerText(1));
        System.out.println("Answer 1 has been displayed");
    }

    private void displayAnswer2() {
        mc_answer_2.setText(getDisplayAnswerText(2));
        System.out.println("Answer 2 has been displayed");
    }

    private void displayAnswer3() {
        mc_answer_3.setText(getDisplayAnswerText(3));
        System.out.println("Answer 3 has been displayed");
    }

    private String getDisplayAnswerText(Integer index) {
        return readingGame.getMultipleChoiceQuestions().get(currentQuestion).getMultipleChoiceAnswers().get(index).getAnswer();
    }

    private void displayAllAnswers() {
        displayAnswer0();
        displayAnswer1();
        displayAnswer2();
        displayAnswer3();
    }

    public void displayQuestionAndAnswers() {
        displayQuestion();
        displayAllAnswers();
    }

    public void displayScore() {
        score_text.setText(String.valueOf(readingGame.getPerformance().getScore()));
    }

    private Boolean alreadyChecked0 = false;
    public void selectAnswer0() {
        if (!alreadyChecked0) {
            selectAnswer(0);
            System.out.println("Answer 0 has been selected");
            alreadyChecked0 = true;
        }
        else {
            deselectAnswer(answerToBeRemoved(0));
            System.out.println("Answer 0 has been deselected");
            alreadyChecked0 = false;
        }
    }

    private Boolean alreadyChecked1 = false;
    public void selectAnswer1() {
        if (!alreadyChecked1) {
            selectAnswer(1);
            System.out.println("Answer 1 has been selected");
            alreadyChecked1 = true;
        }
        else {
            deselectAnswer(answerToBeRemoved(1));
            System.out.println("Answer 1 has been deselected");
            alreadyChecked1 = false;
        }
    }

    private Boolean alreadyChecked2 = false;
    public void selectAnswer2() {
        if (!alreadyChecked2) {
            selectAnswer(2);
            System.out.println("Answer 2 has been selected");
            alreadyChecked2 = true;
        }
        else {
            deselectAnswer(answerToBeRemoved(2));
            System.out.println("Answer 2 has been deselected");
            alreadyChecked2 = false;
        }
    }

    private Boolean alreadyChecked3 = false;
    public void selectAnswer3() {
        if (!alreadyChecked3) {
            selectAnswer(3);
            System.out.println("Answer 3 has been selected");
            alreadyChecked3 = true;
        }
        else {
            deselectAnswer(answerToBeRemoved(3));
            System.out.println("Answer 3 has been deselected");
            alreadyChecked3 = false;
        }
    }

    private void selectAnswer(Integer index) {
        selectedAnswers.add(readingGame.getMultipleChoiceQuestions().get(currentQuestion).getMultipleChoiceAnswers().get(index));
    }

    private void deselectAnswer(MultipleChoiceAnswer selectedAnswer) {
        selectedAnswers.remove(selectedAnswer);
    }

    private MultipleChoiceAnswer answerToBeRemoved(Integer index) {
        return readingGame.getMultipleChoiceQuestions().get(currentQuestion).getMultipleChoiceAnswers().get(index);
    }

    public void confirmAnswerAndAdjustPerformance() {
        if (checkIfAlreadyHasConfirmedAnswer()) {
            if (checkIfSelectedAnswersHasOneAnswer()) {
                confirmAndAdjust();
                displayScore();
                checkIfGameIsCompleted();
                System.out.println("Successfully confirmed answer");
            }
            else {
                System.out.println("Please select one answer");
            }
        }
        else {
            System.out.println("This question already has a confirmed answer");
        }
    }

    private Boolean checkIfAlreadyHasConfirmedAnswer() {
        return !readingGame.getMultipleChoiceQuestions().get(currentQuestion).getAnswerAlreadyConfirmed();
    }

    private Boolean checkIfSelectedAnswersHasOneAnswer() {
        return selectedAnswers.size() == 1;
    }

    private void confirmAndAdjust() {
        readingGame.getMultipleChoiceQuestions().get(currentQuestion).setPickedChoice(selectedAnswers.get(0));
        readingGame.getMultipleChoiceQuestions().get(currentQuestion).confirmAnswer();
        readingGame.adjustPerformanceMultipleChoice(currentQuestion);
        readingGame.getMultipleChoiceQuestions().get(currentQuestion).setAnswerAlreadyConfirmed(true);
    }

    public void checkIfGameIsCompleted() {
        int countConfirmedAnswers = 0;
        for (int i = 0; i < readingGame.getMultipleChoiceQuestions().size(); i++) {
            if (readingGame.getMultipleChoiceQuestions().get(i).getAnswerAlreadyConfirmed()) {
                countConfirmedAnswers++;
            }
        }
        endScreenOrNextQuestion(countConfirmedAnswers);
    }

    private void endScreenOrNextQuestion(Integer countConfirmedAnswers) {
        if (countConfirmedAnswers == readingGame.getMultipleChoiceQuestions().size()) {
            //load end screen (make one)
            System.out.println("Thank you for playing");
        }
        else {
            nextQuestion();
        }
    }

    public void nextQuestion() {
        if (currentQuestion < readingGame.getMultipleChoiceQuestions().size() - 1) {
            currentQuestion++;
            uncheckAllBoxes();
            clearSelectedAnswers();
            displayQuestionAndAnswers();
        }
        else {
            System.out.println("This is the last question");
        }
    }

    public void previousQuestion() {
        if (currentQuestion > 0) {
            currentQuestion--;
            uncheckAllBoxes();
            clearSelectedAnswers();
            displayQuestionAndAnswers();
        }
        else {
            System.out.println("This is the first question");
        }
    }

    private void uncheckAllBoxes() {
        if (mc_answer_box_0.isSelected()) {
            mc_answer_box_0.setSelected(false);
            alreadyChecked0 = false;
        }
        if (mc_answer_box_1.isSelected()) {
            mc_answer_box_1.setSelected(false);
            alreadyChecked1 = false;
        }
        if (mc_answer_box_2.isSelected()) {
            mc_answer_box_2.setSelected(false);
            alreadyChecked2 = false;
        }
        if (mc_answer_box_3.isSelected()) {
            mc_answer_box_3.setSelected(false);
            alreadyChecked3 = false;
        }
    }

    private void clearSelectedAnswers() {
        selectedAnswers.clear();
    }

    public void backToMenu() throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/homepage/homepage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }
}
