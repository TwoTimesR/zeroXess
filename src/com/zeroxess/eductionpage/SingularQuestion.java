package com.zeroxess.eductionpage;

public class SingularQuestion extends Question{
    private SingularAnswer singularAnswer;

    public SingularQuestion(String question, Integer points, String correctAnswer) {
        super(question, points);
        this.singularAnswer = new SingularAnswer(correctAnswer);
    }

    public SingularAnswer getSingularAnswer() {
        return singularAnswer;
    }

    public void setSingularAnswer(SingularAnswer singularAnswer) {
        this.singularAnswer = singularAnswer;
    }
}
