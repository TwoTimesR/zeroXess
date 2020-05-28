package com.zeroxess.eductionpage;

import java.util.ArrayList;

public class Task {
    private Question question;
    private ArrayList<CorrectAnswer> correctAnswers;

    public Task(Question question) {
        this.question = question;
        this.correctAnswers = new ArrayList<>();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<CorrectAnswer> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(ArrayList<CorrectAnswer> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void addCorrectAnswer(CorrectAnswer correctAnswer) {
        correctAnswers.add(correctAnswer);
    }

    public void removeCorrectAnswer(CorrectAnswer correctAnswer) {
        correctAnswers.remove(correctAnswer);
    }
}
