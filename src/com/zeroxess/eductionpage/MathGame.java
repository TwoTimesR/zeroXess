package com.zeroxess.eductionpage;

public abstract class MathGame extends Game {

    public MathGame(){

    }

    public int setSingleDigit() {
        int amount = 1;
        return randomNumbers(amount);
    }


    public int setDoubleDigit() {
        int amount = 2;
        return randomNumbers(amount);
    }

    public int setTripleDigit() {
        int amount = 3;
        return randomNumbers(amount);
    }

    public int randomNumbers(int amount) {
        int min = 0;
        int max;
        if (amount == 1) {
            max = 9;
            int range = max - min +1;
            return (int) (Math.random() * range) + min;
        }
        if (amount == 2) {
            min = 10;
            max = 99;
            int range = max - min +1;
            return (int) (Math.random() * range) + min;

        }
        if (amount == 3) {
            min=100;
            max = 999;
            int range = max - min +1;
            return (int) (Math.random() * range) + min;
        }
        else return 1000;
    }
}