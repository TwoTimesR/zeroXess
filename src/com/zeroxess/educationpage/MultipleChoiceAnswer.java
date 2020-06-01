package com.zeroxess.educationpage;

public class MultipleChoiceAnswer extends Answer {
    private String answer;
    private Boolean correct;

    public MultipleChoiceAnswer(String answer, Boolean correct) {
        this.answer = answer;
        this.correct =correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
