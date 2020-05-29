package com.zeroxess.eductionpage;

public class SingularQuestion extends Question{
    private SingularAnswer singularAnswer;

    public SingularQuestion(String question, Integer points, String correctAnswer) {
        super(question, points);
        this.singularAnswer = new SingularAnswer(correctAnswer);
    }

    @Override
    public Boolean checkAnswer() {
        return getUserAnswer().equals(singularAnswer.getCorrectAnswer());
    }

    public SingularAnswer getSingularAnswer() {
        return singularAnswer;
    }

    public void setSingularAnswer(SingularAnswer singularAnswer) {
        this.singularAnswer = singularAnswer;
    }
}
