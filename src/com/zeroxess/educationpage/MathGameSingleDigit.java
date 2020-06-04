package com.zeroxess.educationpage;

public class MathGameSingleDigit extends MathGame {

    public MathGameSingleDigit(){
        setSingleDigit(randomSingleDigit());

    }

    private int randomSingleDigit(){
        int min = 1;
        int max = 9;
        int range = max - min + 1;
        return ((int)(Math.random()*range)+min);

    }
}
