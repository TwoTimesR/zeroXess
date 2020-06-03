package com.zeroxess.educationpage;

public class MultipleChoiceAnswer extends Answer {
    private String answer;
    private Boolean correct;

    public MultipleChoiceAnswer(String answer, Boolean correct) {
        this.answer = answer.toLowerCase();
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer.toLowerCase();
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
