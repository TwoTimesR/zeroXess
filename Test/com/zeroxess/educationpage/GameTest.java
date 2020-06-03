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

        SingularQuestion sq0 = new SingularQuestion("How many fish did John catch?", "7");

        MultipleChoiceQuestion mcq1 = new MultipleChoiceQuestion("Which answer describes the fisherman's reaction the best.");

        MultipleChoiceAnswer mca1_0 = new MultipleChoiceAnswer("surprised but happy", true);
        MultipleChoiceAnswer mca1_1 = new MultipleChoiceAnswer("very sad", false);
        MultipleChoiceAnswer mca1_2 = new MultipleChoiceAnswer("slightly angry", false);
        MultipleChoiceAnswer mca1_3 = new MultipleChoiceAnswer("unfazed", false);

        mcq1.addMultipleChoiceAnswer(mca1_0);
        mcq1.addMultipleChoiceAnswer(mca1_1);
        mcq1.addMultipleChoiceAnswer(mca1_2);
        mcq1.addMultipleChoiceAnswer(mca1_3);

        System.out.println(readingGame.getReadingText());

        //readingGame.getQuestions().get(1);
        //cant access subclass methods of superclass Question, fix later
    }

    public void startObjects() {

    }
}