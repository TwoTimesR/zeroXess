package com.zeroxess.educationpage;

public class SingularAnswer extends Answer {
    private String correctAnswer;

    public SingularAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer.toLowerCase();
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer.toLowerCase();
    }
}
