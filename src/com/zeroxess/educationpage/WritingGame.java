package com.zeroxess.educationpage;

import java.util.ArrayList;

public class WritingGame extends Game {
    public WritingGame(String gameTitle) {
        super(gameTitle);
    }

    SingularQuestion question = new SingularQuestion("1.What is the name of this fruit?", "apple");
    SingularQuestion question2 = new SingularQuestion("2.What is the name of this insect?", "bee", 20);
    SingularQuestion question3 = new SingularQuestion("3.Which country does this flag belong to?", "japan", 20);
    SingularQuestion question4 = new SingularQuestion("4.What is the name of this food?", "hamburger", 20);
    SingularQuestion question5 = new SingularQuestion("5.What is the name of this animal?", "lion", 20);
    SingularQuestion question6 = new SingularQuestion("6.What is the name of this insect?", "spider", 20);
    SingularQuestion question7 = new SingularQuestion("7.What do you call this vehicle?", "car", 20);
    SingularQuestion question8 = new SingularQuestion("8.What are they doing?", "dancing", 20);
    SingularQuestion question9 = new SingularQuestion("9.What programming language is this?", "java", 20);

    public ArrayList<SingularQuestion> addQuestions() {
        addSingularQuestion(question);
        addSingularQuestion(question2);
        addSingularQuestion(question3);
        addSingularQuestion(question4);
        addSingularQuestion(question5);
        addSingularQuestion(question6);
        addSingularQuestion(question7);
        addSingularQuestion(question8);
        addSingularQuestion(question9);
        return getSingularQuestions();
    }


}
