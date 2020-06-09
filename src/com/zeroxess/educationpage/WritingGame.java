package com.zeroxess.educationpage;

import java.util.ArrayList;

public class WritingGame extends Game {
    // elk vraag heeft als default 20 punten, als ik nu nog een parameter met punten zet word dat toegepast.
    private final SingularQuestion question = new SingularQuestion("1.What is the name of this fruit?", "apple");
    private final SingularQuestion question2 = new SingularQuestion("2.What is the name of this insect?", "bee");
    private final SingularQuestion question3 = new SingularQuestion("3.Which country does this flag belong to?", "japan");
    private final SingularQuestion question4 = new SingularQuestion("4.What is the name of this food?", "hamburger");
    private final SingularQuestion question5 = new SingularQuestion("5.What is the name of this animal?", "lion");
    private final SingularQuestion question6 = new SingularQuestion("6.What is the name of this insect?", "spider");
    private final SingularQuestion question7 = new SingularQuestion("7.What do you call this vehicle?", "car");
    private final SingularQuestion question8 = new SingularQuestion("8.What are they doing?", "dancing");
    private final SingularQuestion question9 = new SingularQuestion("9.What programming language is this?", "java");

    public WritingGame(String gameTitle) {
        super(gameTitle);
    }


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
