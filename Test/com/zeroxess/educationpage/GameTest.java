package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void basicGameTest() {
        ReadingGame readingGame = new ReadingGame("Fisherman's tale");

        readingGame.setReadingText(
                "Once upon a time a fisherman named John caught seven fish.\n" +
                "He later found out that he caught more fish than he thought, this put John in a good mood.\n" +
                "The end."
        );

        SingularQuestion sq0 = new SingularQuestion("How many fish did John catch?", "7", 15);

        MultipleChoiceQuestion mcq0 = new MultipleChoiceQuestion("Which answer describes the fisherman's reaction the best.", 5);

        MultipleChoiceAnswer mca1_0 = new MultipleChoiceAnswer("surprised but happy", true);
        MultipleChoiceAnswer mca1_1 = new MultipleChoiceAnswer("very sad", false);
        MultipleChoiceAnswer mca1_2 = new MultipleChoiceAnswer("slightly angry", false);
        MultipleChoiceAnswer mca1_3 = new MultipleChoiceAnswer("unfazed", false);
        mcq0.addMultipleChoiceAnswer(mca1_0);
        mcq0.addMultipleChoiceAnswer(mca1_1);
        mcq0.addMultipleChoiceAnswer(mca1_2);
        mcq0.addMultipleChoiceAnswer(mca1_3);

        readingGame.addSingularQuestion(sq0);
        readingGame.addMultipleChoiceQuestion(mcq0);

        assertEquals("How many fish did John catch?", readingGame.getSingularQuestions().get(0).getQuestion());
        assertEquals("7", readingGame.getSingularQuestions().get(0).getSingularAnswer().getCorrectAnswer());
        assertEquals(15, readingGame.getSingularQuestions().get(0).getPoints());

        assertEquals("surprised but happy", readingGame.getMultipleChoiceQuestions().get(0).getMultipleChoiceAnswers().get(0).getAnswer()); // surprised but happy, true
        assertFalse(readingGame.getMultipleChoiceQuestions().get(0).getMultipleChoiceAnswers().get(1).getCorrect()); // very sad, false
        assertEquals(4, readingGame.getMultipleChoiceQuestions().get(0).getMultipleChoiceAnswers().size()); // 4 answers total
    }
}