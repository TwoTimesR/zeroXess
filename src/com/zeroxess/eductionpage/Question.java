package com.zeroxess.eductionpage;

public abstract class Question {
    private String question;
    private Integer points;

    public Question(String question, Integer points) {
        this.question = question;
        this.points = points;
    }

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
}
