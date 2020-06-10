package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class ReadingGameController {
    private ReadingGame readingGame = new ReadingGame("The Adventure's of Jim");

    public void readingGameSetUp() {
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

        MultipleChoiceQuestion mcq_1 = new MultipleChoiceQuestion("What does Jim mainly do");
        MultipleChoiceAnswer mca_1_0 = new MultipleChoiceAnswer("Sell fruit on the market", false);
        MultipleChoiceAnswer mca_1_1 = new MultipleChoiceAnswer("Bureaucracy", false);
        MultipleChoiceAnswer mca_1_2 = new MultipleChoiceAnswer("Manage a dock", true);
        MultipleChoiceAnswer mca_1_3 = new MultipleChoiceAnswer("Explore the world", false);
        mcq_0.addMultipleChoiceAnswer(mca_1_0);
        mcq_0.addMultipleChoiceAnswer(mca_1_1);
        mcq_0.addMultipleChoiceAnswer(mca_1_2);
        mcq_0.addMultipleChoiceAnswer(mca_1_3);

        MultipleChoiceQuestion mcq_2 = new MultipleChoiceQuestion("What did Jim see a long distance from the docks");
        MultipleChoiceAnswer mca_2_0 = new MultipleChoiceAnswer("A strange boat", true);
        MultipleChoiceAnswer mca_2_1 = new MultipleChoiceAnswer("A sea dragon", false);
        MultipleChoiceAnswer mca_2_2 = new MultipleChoiceAnswer("A giant whale", false);
        MultipleChoiceAnswer mca_2_3 = new MultipleChoiceAnswer("A mermaid", false);
        mcq_0.addMultipleChoiceAnswer(mca_2_0);
        mcq_0.addMultipleChoiceAnswer(mca_2_1);
        mcq_0.addMultipleChoiceAnswer(mca_2_2);
        mcq_0.addMultipleChoiceAnswer(mca_2_3);

        readingGame.addMultipleChoiceQuestion(mcq_0);
        readingGame.addMultipleChoiceQuestion(mcq_1);
        readingGame.addMultipleChoiceQuestion(mcq_2);
    }

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
    private Button previous_question;

    @FXML
    private Button confirm_answer;

    @FXML
    private Button next_question;

    @FXML
    private Label score;

    @FXML
    private Label total_score_integer;

    @FXML
    private Button back;

    private Integer currentQuestion = 0;

    public void initialize() {
        readingGameSetUp();
    }

    public void displayReadingText() {
        reading_text.setText(readingGame.getReadingText());
    }

    private void displayQuestion(Integer index) {
        question_text.setText(readingGame.getMultipleChoiceQuestions().get(index).getQuestion());
    }

    private void displayAnswer0(Integer index) {
        mc_answer_0.setText(readingGame.getMultipleChoiceQuestions().get(index).getMultipleChoiceAnswers().get(0).getAnswer());
    }

    private void displayAnswer1(Integer index) {
        mc_answer_1.setText(readingGame.getMultipleChoiceQuestions().get(index).getMultipleChoiceAnswers().get(1).getAnswer());
    }

    private void displayAnswer2(Integer index) {
        mc_answer_2.setText(readingGame.getMultipleChoiceQuestions().get(index).getMultipleChoiceAnswers().get(2).getAnswer());
    }

    private void displayAnswer3(Integer index) {
        mc_answer_3.setText(readingGame.getMultipleChoiceQuestions().get(index).getMultipleChoiceAnswers().get(3).getAnswer());
    }

    private void displayAllAnswers(Integer index) {
        displayAnswer0(index);
        displayAnswer1(index);
        displayAnswer2(index);
        displayAnswer3(index);
    }

    public void showQuestionAndAnswers(Integer index) {
        displayQuestion(index);
        displayAllAnswers(index);
    }

    public void nextQuestion() {
        if (currentQuestion < readingGame.getMultipleChoiceQuestions().size()) {
            currentQuestion++;
            showQuestionAndAnswers(currentQuestion);
        }
        else {
            System.out.println("This is the last question");
        }
    }

    public void previousQuestion() {
        if (currentQuestion > 0) {
            currentQuestion--;
            showQuestionAndAnswers(currentQuestion);
        }
        else {
            System.out.println("This is the first question");
        }
    }

    public void selectAnswer(Integer index) {
        //selected answer = pickedChoice
    }

    public void confirmAnswerAndAdjustPerformance(Integer index) {
        readingGame.getMultipleChoiceQuestions().get(index).checkAnswer();
        readingGame.adjustPerformanceMultipleChoice(index);
    }

    public void displayScore() {
        //total_score_integer might be wrong
    }

    public void backToMenu() {
        //end game and go back to the menu
    }
}
