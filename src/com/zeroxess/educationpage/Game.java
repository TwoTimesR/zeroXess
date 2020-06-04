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

    protected Game() {
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
        this.multipleChoiceQuestions.add(multipleChoiceQuestion);
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
