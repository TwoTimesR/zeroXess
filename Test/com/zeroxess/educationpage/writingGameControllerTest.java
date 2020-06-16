package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class writingGameControllerTest {
    WritingGame game = new WritingGame("Test");

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

    @Test
    public void questionTest() {
        writingGameSetup();
        SingularQuestion question = new SingularQuestion("1.What is the name of this fruit?","apple");

        System.out.println(game.getSingularQuestions().get(0).getQuestion());
        assertEquals(game.getSingularQuestions().get(0).getQuestion(), question.getQuestion());
    }

    @Test
    public void answerTest() {
        writingGameSetup();
        String ant = "apple";
        assertEquals(game.getSingularQuestions().get(0).getSingularAnswer().getCorrectAnswer(), ant);
    }
    @Test
    public void answerTest2() {
        writingGameSetup();
        String ant2 = "bee";
        assertEquals(game.getSingularQuestions().get(1).getSingularAnswer().getCorrectAnswer(), ant2);
    }
    @Test
    public void answerTest3() {
        writingGameSetup();
        String ant3 = "japan";
        assertEquals(game.getSingularQuestions().get(2).getSingularAnswer().getCorrectAnswer(), ant3);
    }
    @Test
    public void answerTest4() {
        writingGameSetup();
        String ant4 = "hamburger";
        assertEquals(game.getSingularQuestions().get(3).getSingularAnswer().getCorrectAnswer(), ant4);
    }
    @Test
    public void answerTest5() {
        writingGameSetup();
        String ant5 = "lion";
        assertEquals(game.getSingularQuestions().get(4).getSingularAnswer().getCorrectAnswer(), ant5);
    }
    @Test
    public void answerTest6() {
        writingGameSetup();
        String ant6 = "spider" ;
        assertEquals(game.getSingularQuestions().get(5).getSingularAnswer().getCorrectAnswer(), ant6);
    }
    @Test
    public void answerTest7() {
        writingGameSetup();
        String ant7 = "car";
        assertEquals(game.getSingularQuestions().get(6).getSingularAnswer().getCorrectAnswer(), ant7);
    }
    @Test
    public void answerTest8() {
        writingGameSetup();
        String ant8 ="dancing";
        assertEquals(game.getSingularQuestions().get(7).getSingularAnswer().getCorrectAnswer(), ant8);
    }
    @Test
    public void answerTest9() {
        writingGameSetup();
        String ant9 = "java";
        assertEquals(game.getSingularQuestions().get(8).getSingularAnswer().getCorrectAnswer(), ant9);
    }

}