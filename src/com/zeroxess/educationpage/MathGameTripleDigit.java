package com.zeroxess.educationpage;

public class MathGameTripleDigit extends MathGame {

    public MathGameTripleDigit(){
        setDigit(randomTripleDigit());

    }

    private int randomTripleDigit(){
        int min = 100;
        int max = 999;
        int range = max - min + 1;
        return ((int)(Math.random()*range)+min);

    }
}