package com.zeroxess.eductionpage;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{
    private ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers;

    public MultipleChoiceQuestion(String question, Integer points) {
        super(question, points);
        this.multipleChoiceAnswers = new ArrayList<>();
    }

    public ArrayList<MultipleChoiceAnswer> getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

    public void setMultipleChoiceAnswers(ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers) {
        this.multipleChoiceAnswers = multipleChoiceAnswers;
    }

    //add

    //remove
}
