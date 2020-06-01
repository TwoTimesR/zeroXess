package com.zeroxess.educationpage;

public abstract class Question {
    private String question;
    private Integer points;
    private String userAnswer;

    public Question(String question, Integer points) {
        this.question = question;
        this.points = points;
    }

    public abstract Boolean checkAnswer();

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
