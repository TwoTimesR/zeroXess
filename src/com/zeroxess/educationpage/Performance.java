package com.zeroxess.educationpage;

public class Performance {
    private Integer correctlyAnswered;
    private Integer incorrectlyAnswered;
    private Integer score;

    public Performance() {
        this.correctlyAnswered = 0;
        this.incorrectlyAnswered = 0;
        this.score = 0;
    }

    public Integer getCorrectlyAnswered() {
        return correctlyAnswered;
    }

    public void setCorrectlyAnswered(Integer correctlyAnswered) {
        this.correctlyAnswered = correctlyAnswered;
    }

    public Integer getIncorrectlyAnswered() {
        return incorrectlyAnswered;
    }

    public void setIncorrectlyAnswered(Integer incorrectlyAnswered) {
        this.incorrectlyAnswered = incorrectlyAnswered;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
