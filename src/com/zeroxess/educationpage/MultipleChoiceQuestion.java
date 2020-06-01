package com.zeroxess.educationpage;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{
    private ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers;

    public MultipleChoiceQuestion(String question, Integer points) {
        super(question, points);
        this.multipleChoiceAnswers = new ArrayList<>();
    }

    @Override
    public Boolean checkAnswer() {
        int pickedChoice = Integer.parseInt(getUserAnswer()); // user picks a choice ranging from 1 to n
        return multipleChoiceAnswers.get(pickedChoice).getCorrect();
    }

    public ArrayList<MultipleChoiceAnswer> getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

    public void setMultipleChoiceAnswers(ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers) {
        this.multipleChoiceAnswers = multipleChoiceAnswers;
    }

    public void addMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {
        multipleChoiceAnswers.add(multipleChoiceAnswer);
    }

    public void removeMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {
        multipleChoiceAnswers.remove(multipleChoiceAnswer);
    }
}
