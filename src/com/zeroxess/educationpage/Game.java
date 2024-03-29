package com.zeroxess.educationpage;

import java.util.ArrayList;

public abstract class Game {
    private String title;
    private ArrayList<SingularQuestion> singularQuestions;
    private ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions;
    private Integer amountOfQuestions;
    private Performance performance;

    public Game(String gameTitle) {
        this.title = gameTitle;
        this.singularQuestions = new ArrayList<>();
        this.multipleChoiceQuestions = new ArrayList<>();
        this.amountOfQuestions = singularQuestions.size() + multipleChoiceQuestions.size();
        this.performance = new Performance();
    }

    public void adjustPerformanceSingular(Integer index) {
        if (singularQuestions.get(index).getAnsweredCorrectly()) {
            performance.setScore(performance.getScore() + singularQuestions.get(index).getPoints());
            positiveAdjustment();
        }
        else {
            negativeAdjustment();
        }
    }

    public void adjustPerformanceMultipleChoice(Integer index) {
        if (multipleChoiceQuestions.get(index).getAnsweredCorrectly()) {
            performance.setScore(performance.getScore() + multipleChoiceQuestions.get(index).getPoints());
            positiveAdjustment();
        }
        else {
            negativeAdjustment();
        }
    }

    private void positiveAdjustment() {
        performance.setCorrectlyAnswered(performance.getCorrectlyAnswered() + 1);
    }

    private void negativeAdjustment() {
        performance.setIncorrectlyAnswered(performance.getIncorrectlyAnswered() + 1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SingularQuestion> getSingularQuestions() {
        return singularQuestions;
    }

    public void setSingularQuestions(ArrayList<SingularQuestion> singularQuestions) {
        this.singularQuestions = singularQuestions;
    }

    public void addSingularQuestion(SingularQuestion singularQuestion) {
        this.singularQuestions.add(singularQuestion);
    }

    public void removeSingularQuestion(SingularQuestion singularQuestion) {
        this.singularQuestions.remove(singularQuestion);
    }

    public ArrayList<MultipleChoiceQuestion> getMultipleChoiceQuestions() {
        return multipleChoiceQuestions;
    }

    public void setMultipleChoiceQuestions(ArrayList<MultipleChoiceQuestion> multipleChoiceQuestions) {
        this.multipleChoiceQuestions = multipleChoiceQuestions;
    }

    public void addMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
        if (multipleChoiceQuestion.getMultipleChoiceAnswers().size() == 4) {
            this.multipleChoiceQuestions.add(multipleChoiceQuestion);
            System.out.println("Question has been added");
        }
        else {
            System.out.println("This question needs 4 possible answers");
        }
    }

    public void removeMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
        this.multipleChoiceQuestions.remove(multipleChoiceQuestion);
    }

    public Integer getAmountOfQuestions() {
        this.amountOfQuestions = singularQuestions.size() + multipleChoiceQuestions.size();
        return amountOfQuestions;
    }

    public void setAmountOfQuestions(Integer amountOfQuestions) {
        this.amountOfQuestions = amountOfQuestions;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
