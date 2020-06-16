package com.zeroxess.educationpage;

public class MathGameDoubleDigit extends MathGame {

    public MathGameDoubleDigit(){
        setDigit(randomDoubleDigit());

    }

    private int randomDoubleDigit(){
        int min = 10;
        int max = 99;
        int range = max - min + 1;
        return ((int)(Math.random()*range)+min);

    }
}