package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTest {
    Performance performance = new Performance();

    @Test
    public void correctAmount() {
        performance.setIncorrectlyAnswered(1);
        performance.setCorrectlyAnswered(6);
        int totalAmountOfQuestions = performance.getCorrectlyAnswered() + performance.getIncorrectlyAnswered();
        assertEquals(7, totalAmountOfQuestions);
    }

    @Test
    public void addQuestionPoints() {
        SingularQuestion singularQuestion = new SingularQuestion("nothing", "-", 17);
        int totalScore = 50;
        performance.setScore(singularQuestion.getPoints());
        totalScore += performance.getScore();
        assertEquals(67, totalScore);
    }
}