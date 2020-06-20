package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathGameSingleDigitTest {
    MathGameSingleDigit testDIgit = new MathGameSingleDigit();

    @Test
    void doubleDigitTest(){
        int test = testDIgit.randomSingleDigit();

        assertFalse(test >= 10);
        assertFalse(test <= 0);


    }





}