package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathGameControllerTest {
    MathGameController mathGameControllerTest= new MathGameController();

    @Test
    void onStartClickedTest(){

        mathGameControllerTest.onStartClicked();

        assertTrue(mathGameControllerTest.normalPlayButton.isVisible());
        assertTrue(mathGameControllerTest.infinitePlayButton.isVisible());
        assertTrue(mathGameControllerTest.returnToStartButton.isVisible());

       assertFalse(mathGameControllerTest.startGame.isVisible());
       assertFalse(mathGameControllerTest.backButton.isVisible());
    }

    @Test
    void returnToStartTest(){
        mathGameControllerTest.returnToStart();

        assertFalse(mathGameControllerTest.normalPlayButton.isVisible());
        assertFalse(mathGameControllerTest.infinitePlayButton.isVisible());
        assertFalse(mathGameControllerTest.returnToStartButton.isVisible());

        assertTrue(mathGameControllerTest.startGame.isVisible());
        assertTrue(mathGameControllerTest.backButton.isVisible());
    }

    @Test
        void normalPlayTest(){
        mathGameControllerTest.normalPlay();

        assertFalse(mathGameControllerTest.normalPlayButton.isVisible());
        assertFalse(mathGameControllerTest.infinitePlayButton.isVisible());
        assertFalse(mathGameControllerTest.returnToStartButton.isVisible());

        assertTrue(mathGameControllerTest.normalDificulty.isVisible());
        assertTrue(mathGameControllerTest.hardDificulty.isVisible());
        assertTrue(mathGameControllerTest.returnToGameSelect.isVisible());

        assertTrue(mathGameControllerTest.gameMode);
    }

    @Test
        void infinitePlayTest(){
        mathGameControllerTest.infinitePlay();

        assertFalse(mathGameControllerTest.normalPlayButton.isVisible());
        assertFalse(mathGameControllerTest.infinitePlayButton.isVisible());
        assertFalse(mathGameControllerTest.returnToStartButton.isVisible());

        assertTrue(mathGameControllerTest.normalDificulty.isVisible());
        assertTrue(mathGameControllerTest.hardDificulty.isVisible());
        assertTrue(mathGameControllerTest.returnToGameSelect.isVisible());

        assertFalse(mathGameControllerTest.gameMode);
    }

    @Test
    void returnToStartClickedTest(){
        mathGameControllerTest.returnToGameSelect();

        assertFalse(mathGameControllerTest.normalPlayButton.isVisible());
        assertFalse(mathGameControllerTest.hardDificulty.isVisible());
        assertFalse(mathGameControllerTest.returnToGameSelect.isVisible());

        assertTrue(mathGameControllerTest.normalPlayButton.isVisible());
        assertTrue(mathGameControllerTest.infinitePlayButton.isVisible());
        assertTrue(mathGameControllerTest.returnToStartButton.isVisible());

    }

    @Test
    void normalDIfficultyclickedTest(){
        mathGameControllerTest.normalDificulty();

        assertTrue(mathGameControllerTest.gameDifficulty);

        assertTrue(mathGameControllerTest.number1.isVisible());
        assertTrue(mathGameControllerTest.number2.isVisible());
        assertTrue(mathGameControllerTest.mathSign1.isVisible());
        assertTrue(mathGameControllerTest.equalsSign.isVisible());
        assertTrue(mathGameControllerTest.scoreLabel.isVisible());

        assertEquals(0, mathGameControllerTest.scoreAmountTemp);
        assertEquals("0", mathGameControllerTest.scoreLabel.getText());

        assertTrue(mathGameControllerTest.scoreName.isVisible());
        assertTrue(mathGameControllerTest.questionLabel.isVisible());
        assertTrue(mathGameControllerTest.numberQuestion.isVisible());

        assertEquals("1",mathGameControllerTest.numberQuestion.getText());
        assertEquals(1,mathGameControllerTest.questionNumber);
        assertEquals(0,mathGameControllerTest.correct);
        assertEquals(0,mathGameControllerTest.incorrect);

        assertTrue(mathGameControllerTest.backToDificultySelect.isVisible());
        assertTrue(mathGameControllerTest.AnswerTextField.isVisible());
        assertTrue(mathGameControllerTest.checkAnswerButton.isVisible());
        assertTrue(mathGameControllerTest.QuitButton.isVisible());

        assertFalse(mathGameControllerTest.normalDificulty.isVisible());
        assertFalse(mathGameControllerTest.hardDificulty.isVisible());
        assertFalse(mathGameControllerTest.returnToGameSelect.isVisible());

        assertTrue(mathGameControllerTest.AnswerTextField.getText().isEmpty());

    }

    @Test
    void hardDifficultyCLickedTest(){
        mathGameControllerTest.displayGameScreanNormal();

        assertTrue(mathGameControllerTest.mathSign2.isVisible());
        assertTrue(mathGameControllerTest.number3.isVisible());

        assertFalse(mathGameControllerTest.gameDifficulty);
    }

    @Test
    void onBackToDIficultySelectTest(){
        mathGameControllerTest.onBackToDIficultySelect();

        assertFalse(mathGameControllerTest.number1.isVisible());
        assertFalse(mathGameControllerTest.number2.isVisible());
        assertFalse(mathGameControllerTest.mathSign1.isVisible());
        assertFalse(mathGameControllerTest.equalsSign.isVisible());
        assertFalse(mathGameControllerTest.scoreLabel.isVisible());
        assertFalse(mathGameControllerTest.scoreName.isVisible());
        assertFalse(mathGameControllerTest.questionLabel.isVisible());
        assertFalse(mathGameControllerTest.numberQuestion.isVisible());
        assertFalse(mathGameControllerTest.backToDificultySelect.isVisible());
        assertFalse(mathGameControllerTest.AnswerTextField.isVisible());
        assertFalse(mathGameControllerTest.checkAnswerButton.isVisible());
        assertFalse(mathGameControllerTest.nextQuestion.isVisible());
        assertFalse(mathGameControllerTest.QuitButton.isVisible());
        assertFalse(mathGameControllerTest.mathSign2.isVisible());
        assertFalse(mathGameControllerTest.number3.isVisible());

        assertTrue(mathGameControllerTest.normalDificulty.isVisible());
        assertTrue(mathGameControllerTest.hardDificulty.isVisible());
        assertTrue(mathGameControllerTest.returnToGameSelect.isVisible());

    }

    @Test
    void onQuitButtonClickedTest(){
        mathGameControllerTest.onQuitButtonClicked();

        assertTrue(mathGameControllerTest.farewellMessage.isVisible());
        assertTrue(mathGameControllerTest.home_Page.isVisible());
        assertTrue(mathGameControllerTest.endTotal_score.isVisible());
        assertTrue(mathGameControllerTest.endCorrectAnswers.isVisible());
        assertTrue(mathGameControllerTest.endScoreLabel.isVisible());
        assertTrue(mathGameControllerTest.endIncorrectAnswers.isVisible());
        assertTrue(mathGameControllerTest.endCorectAnswersLabel.isVisible());
        assertTrue(mathGameControllerTest.endIncorectAnswersLabel.isVisible());

        assertFalse(mathGameControllerTest.normalDificulty.isVisible());
        assertFalse(mathGameControllerTest.hardDificulty.isVisible());
        assertFalse(mathGameControllerTest.returnToGameSelect.isVisible());
        assertFalse(mathGameControllerTest.titleLabel.isVisible());

    }

    @Test
    void onCheckClickedTest(){
        mathGameControllerTest.onCheckAswerClicked();

        assertFalse(mathGameControllerTest.checkAnswerButton.isVisible());
        assertTrue(mathGameControllerTest.nextQuestion.isVisible());

    }


}