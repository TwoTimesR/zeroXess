package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathGameDoubleDigitTest {
    MathGameDoubleDigit testDIgit = new MathGameDoubleDigit();

    @Test
    void doubleDigitTest(){
        int test = testDIgit.randomDoubleDigit();

        assertFalse(test >= 100);
        assertFalse(test <= 9);


    }




}