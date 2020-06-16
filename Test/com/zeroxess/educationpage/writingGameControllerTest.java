package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class writingGameControllerTest {

    @Test
    public void questionTest() {
        SingularQuestion question = new SingularQuestion("1.What is the name of this fruit?","apple");
        WritingGame game = new WritingGame("test");

        System.out.println(game.getSingularQuestions().get(0).getQuestion());
        assertEquals(game.getSingularQuestions().get(0).getQuestion(),question.getQuestion());
    }


    @Test
    public void answerTest(){
        WritingGame game = new WritingGame("test1");
        String ant = "apple";
        assertEquals(game.getSingularQuestions().get(0).getSingularAnswer().getCorrectAnswer(),ant);
    }
    @Test
    public void answerTest2(){
        WritingGame game = new WritingGame("test2");
        String ant2 = "bee";
        assertEquals(game.getSingularQuestions().get(1).getSingularAnswer().getCorrectAnswer(),ant2);
    }
    @Test
    public void answerTest3(){
        WritingGame game = new WritingGame("test3");
        String ant3 = "japan";
        assertEquals(game.getSingularQuestions().get(2).getSingularAnswer().getCorrectAnswer(),ant3);
    }
    @Test
    public void answerTest4(){
        WritingGame game = new WritingGame("test4");
        String ant4 = "hamburger";
        assertEquals(game.getSingularQuestions().get(3).getSingularAnswer().getCorrectAnswer(),ant4);
    }
    @Test
    public void answerTest5(){
        WritingGame game = new WritingGame("test5");
        String ant5 = "lion";
        assertEquals(game.getSingularQuestions().get(4).getSingularAnswer().getCorrectAnswer(),ant5);
    }
    @Test
    public void answerTest6(){
        WritingGame game = new WritingGame("test6");
    String ant6 = "spider" ;
    assertEquals(game.getSingularQuestions().get(5).getSingularAnswer().getCorrectAnswer(),ant6);
    }
    @Test
    public void answerTest7(){
        WritingGame game = new WritingGame("test7");
        String ant7 = "car";
        assertEquals(game.getSingularQuestions().get(6).getSingularAnswer().getCorrectAnswer(),ant7);
    }
    @Test
    public void answerTest8(){
        WritingGame game = new WritingGame("test8");
        String ant8 ="dancing";
        assertEquals(game.getSingularQuestions().get(7).getSingularAnswer().getCorrectAnswer(),ant8);
    }
    @Test
    public void answertest9(){
        WritingGame game = new WritingGame("test9");
        String ant9 = "java";
        assertEquals(game.getSingularQuestions().get(8).getSingularAnswer().getCorrectAnswer(),ant9);
    }

}