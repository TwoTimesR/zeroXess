package com.zeroxess.eductionpage;

public class SingularAnswer extends Answer {
    private String correctAnswer;

    public SingularAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
