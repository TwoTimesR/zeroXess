package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingGameControllerTest {

    /*
    slightly modified version of confirmAnswerAndAdjustPerformance method from ReadingGameController.java line 238
    so that it can be tested. ('O' stands for outcome)
     */

    public String confirmAnswerAndAdjustPerformance(Boolean hasConfirmedAnswer, Integer selectedAnswersSize) {
        if (checkIfAlreadyHasConfirmedAnswer(hasConfirmedAnswer)) {
            if (checkIfSelectedAnswersHasOneAnswer(selectedAnswersSize)) {
                return "Successfully confirmed answer"; // O1
            }
            else {
                return "Please select one answer"; // O2
            }
        }
        else {
            return "This question already has a confirmed answer"; // O3
        }
    }

    private Boolean checkIfAlreadyHasConfirmedAnswer(Boolean hasConfirmedAnswer) {
        return hasConfirmedAnswer;
    }

    private Boolean checkIfSelectedAnswersHasOneAnswer(Integer selectedAnswersSize) {
        return selectedAnswersSize == 1;
    }

    /*
    Multiple condition coverage (automatically includes decision coverage and condition coverage)
    also includes modified condition/modified decision coverage but that's coincidence
     */

    String O1 = "Successfully confirmed answer";
    String O2 = "Please select one answer";
    String O3 = "This question already has a confirmed answer";

    @Test
    public void MCC1() {
        assertEquals(O1, confirmAnswerAndAdjustPerformance(true, 1));
    }

    @Test
    public void MCC2() {
        assertEquals(O2, confirmAnswerAndAdjustPerformance(true, 9));
    }

    @Test
    public void MCC3() {
        assertEquals(O3, confirmAnswerAndAdjustPerformance(false, 1));
    }

    @Test
    public void MCC4() {
        assertEquals(O3, confirmAnswerAndAdjustPerformance(false, 9));
    }
}