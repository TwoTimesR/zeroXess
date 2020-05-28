package com.zeroxess.eductionpage;

public abstract class MathGame extends Game {
    private int singleDigit;
    private int doubleDigit;
    private int tripleDigit;


    public MathGame(){

    }

    public int getSingleDigit() {
        return singleDigit;
    }

    public void setSingleDigit() {
        int amount = 1;
        this.singleDigit = randomNumbers(amount);
    }

    public int getDoubleDigit() {
        return doubleDigit;
    }

    public void setDoubleDigit() {
        int amount = 2;
        this.doubleDigit = randomNumbers(amount);
    }

    public int getTripleDigit() {
        return tripleDigit;
    }

    public void setTripleDigit() {
        int amount = 3;
        this.tripleDigit = randomNumbers(amount);
    }

    public int randomNumbers(int amount) {
        int min = 0;
        int max = 1;
        if (amount == 1) {
            max = 9;
            int range = max - min;
            int singleDigit = (int) (Math.random() * range) + min;
            return singleDigit;
        }
        if (amount == 2) {
            min = 10;
            max = 99;
            int range = max - min;
            int doubleDigit = (int) (Math.random() * range) + min;
            return doubleDigit;

        }
        if (amount == 3) {
            min=100;
            max = 999;
            int range = max - min;
            int tripleDigit = (int) (Math.random() * range) + min;
            return tripleDigit;
        }
        else return 1000;
    }
}
