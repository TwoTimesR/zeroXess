package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathGameTripleDigitTest {
    MathGameTripleDigit testDIgit = new MathGameTripleDigit();

    @Test
    void doubleDigitTest(){
        int test = testDIgit.randomTripleDigit();

        assertFalse(test >= 1000);
        assertFalse(test <= 99);


    }





}