package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathGameTripleDigitTest {
    MathGameTripleDigit testDIgit = new MathGameTripleDigit();

    @Test
    void tripleDigitTest(){
        int test = testDIgit.randomTripleDigit();

        assertFalse(test >= 1000 || test <=99);
        assertTrue(test <= 1000 || test >=99);



    }
}