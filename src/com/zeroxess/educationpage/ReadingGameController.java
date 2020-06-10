package com.zeroxess.educationpage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class ReadingGameController {
    private ReadingGame readingGame = new ReadingGame("The Adventure's of Jim");

    @FXML
    Pane pane;

    @FXML
    TextArea reading_text;

    @FXML
    TextArea question_text;

    @FXML
    TextArea mc_answer_0;

    @FXML
    TextArea mc_answer_1;

    @FXML
    TextArea mc_answer_2;

    @FXML
    TextArea mc_answer_3;

    @FXML
    Button previous_question;

    @FXML
    Button confirm_answer;

    @FXML
    Button next_question;

    @FXML
    Label score;

    @FXML
    Label total_score_integer;

    @FXML
    Button back;
}
