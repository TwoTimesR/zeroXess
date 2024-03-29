package com.zeroxess.educationpage;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{
    private ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers;
    private MultipleChoiceAnswer pickedChoice;

    public MultipleChoiceQuestion(String question, Integer points) {
        super(question, points);
        this.multipleChoiceAnswers = new ArrayList<>();
    }

    public MultipleChoiceQuestion(String question) {
        super(question);
        this.multipleChoiceAnswers = new ArrayList<>();
    }

    @Override
    public void confirmAnswer() {
        setAnsweredCorrectly(pickedChoice.getCorrect());
    }

    public ArrayList<MultipleChoiceAnswer> getMultipleChoiceAnswers() {
        return multipleChoiceAnswers;
    }

    public void setMultipleChoiceAnswers(ArrayList<MultipleChoiceAnswer> multipleChoiceAnswers) {
        this.multipleChoiceAnswers = multipleChoiceAnswers;
    }

    public void addMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {
        if (multipleChoiceAnswers.size() < 4) {
            multipleChoiceAnswers.add(multipleChoiceAnswer);
            System.out.println("Answer has been added, current amount of answers: " + multipleChoiceAnswers.size());
        }
        else {
            System.out.println("This question already has 4 possible answers");
        }
    }

    public void removeMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {
        multipleChoiceAnswers.remove(multipleChoiceAnswer);
    }

    public MultipleChoiceAnswer getPickedChoice() {
        return pickedChoice;
    }

    public void setPickedChoice(MultipleChoiceAnswer pickedChoice) {
        this.pickedChoice = pickedChoice;
    }
}
