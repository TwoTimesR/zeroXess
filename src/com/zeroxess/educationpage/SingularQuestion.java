package com.zeroxess.educationpage;

public class SingularQuestion extends Question{
    private SingularAnswer singularAnswer;
    private String userAnswer;

    public SingularQuestion(String question, Integer points, String correctAnswer) {
        super(question, points);
        this.singularAnswer = new SingularAnswer(correctAnswer);
    }

    public SingularQuestion(String question, String correctAnswer) {
        super(question);
        this.singularAnswer = new SingularAnswer(correctAnswer);
    }

    @Override
    public Boolean checkAnswer() {
        return userAnswer.equals(singularAnswer.getCorrectAnswer());
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public SingularAnswer getSingularAnswer() {
        return singularAnswer;
    }

    public void setSingularAnswer(SingularAnswer singularAnswer) {
        this.singularAnswer = singularAnswer;
    }
}
