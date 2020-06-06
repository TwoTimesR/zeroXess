package com.zeroxess.educationpage;

import java.util.ArrayList;

public class WritingGame extends Game {
    public WritingGame(String gameTitle) {
        super(gameTitle);
    }

    private ArrayList<String> questionList = new ArrayList<>();
    private ArrayList<String> answerList = new ArrayList<>();

    SingularQuestion question = new SingularQuestion("1.What is the name of this fruit?", "apple");
    SingularQuestion question2 = new SingularQuestion("2.What is the name of this insect?", "bee");
    SingularQuestion question3 = new SingularQuestion("3.Which country does this flag belong to?", "japan");
    SingularQuestion question4 = new SingularQuestion("4.What is the name of this food?", "hamburger");
    SingularQuestion question5 = new SingularQuestion("5.What is the name of this animal?", "lion");
    SingularQuestion question6 = new SingularQuestion("6.What is the name of this insect?", "spider");
    SingularQuestion question7 = new SingularQuestion("7.What do you call this vehicle?", "car");
    SingularQuestion question8 = new SingularQuestion("8.What are they doing?", "dancing");
    SingularQuestion question9 = new SingularQuestion("9.What programming language is this?", "java");

    public ArrayList<String> createQuestions() {
        questionList.add(question.getQuestion());
        questionList.add(question2.getQuestion());
        questionList.add(question3.getQuestion());
        questionList.add(question4.getQuestion());
        questionList.add(question5.getQuestion());
        questionList.add(question6.getQuestion());
        questionList.add(question7.getQuestion());
        questionList.add(question8.getQuestion());
        questionList.add(question9.getQuestion());
        return questionList;
    }
    public ArrayList<String> createAnswers(){
        answerList.add(question.getSingularAnswer().getCorrectAnswer());
        answerList.add(question2.getSingularAnswer().getCorrectAnswer());
        answerList.add(question3.getSingularAnswer().getCorrectAnswer());
        answerList.add(question4.getSingularAnswer().getCorrectAnswer());
        answerList.add(question5.getSingularAnswer().getCorrectAnswer());
        answerList.add(question6.getSingularAnswer().getCorrectAnswer());
        answerList.add(question7.getSingularAnswer().getCorrectAnswer());
        answerList.add(question8.getSingularAnswer().getCorrectAnswer());
        answerList.add(question9.getSingularAnswer().getCorrectAnswer());
        return answerList;
    }



}
