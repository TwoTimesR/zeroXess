package com.zeroxess.educationpage;

public abstract class Question {
    private String question;
    private Integer points;
    private Boolean answeredCorrectly;

    public Question(String question, Integer points) {
        this.question = question;
        this.points = points;
        this.answeredCorrectly = null;
    }

    public Question(String question) {
        this.question = question;
        this.points = 20;
    }

    public abstract void checkAnswer();

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

    public Boolean getAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(Boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
}
