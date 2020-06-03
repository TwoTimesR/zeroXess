package com.zeroxess.educationpage;

import java.util.ArrayList;

public abstract class Game {
    private String title;
    private ArrayList<Question> questions;
    private Integer amountOfQuestions;
    private Performance performance;

    public Game(String gameTitle) {
        this.title = gameTitle;
        this.questions = new ArrayList<>();
        this.amountOfQuestions = questions.size();
        this.performance = new Performance();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        amountOfQuestions++;
        amountOfQuestions = questions.size();
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
        amountOfQuestions--;
        amountOfQuestions = questions.size();
    }

    public Integer getAmountOfQuestions() {
        return questions.size();
    }

    public void setAmountOfQuestions(Integer amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
