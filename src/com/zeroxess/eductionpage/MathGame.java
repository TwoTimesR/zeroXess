package com.zeroxess.eductionpage;

public abstract class MathGame extends Game {

    public MathGame(){

    }

    public int setSingleDigit() {
        int amount = 1;
        int singleDigit = randomNumbers(amount);
        return singleDigit;
    }


    public int setDoubleDigit() {
        int amount = 2;
        int doubleDigit = randomNumbers(amount);
        return doubleDigit;
    }

    public int setTripleDigit() {
        int amount = 3;
        int tripleDigit = randomNumbers(amount);
        return tripleDigit;
    }

    public int randomNumbers(int amount) {
        int min = 0;
        int max = 1;
        if (amount == 1) {
            max = 9;
            int range = max - min +1;
            int singleDigit = (int) (Math.random() * range) + min;
            return singleDigit;
        }
        if (amount == 2) {
            min = 10;
            max = 99;
            int range = max - min +1;
            int doubleDigit = (int) (Math.random() * range) + min;
            return doubleDigit;

        }
        if (amount == 3) {
            min=100;
            max = 999;
            int range = max - min +1;
            int tripleDigit = (int) (Math.random() * range) + min;
            return tripleDigit;
        }
        else return 1000;
    }
}