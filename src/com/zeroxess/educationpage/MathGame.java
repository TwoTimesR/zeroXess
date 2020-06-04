package com.zeroxess.educationpage;

public abstract class MathGame extends Game {
    protected int singleDigit;
    protected int doubleDigit;
    protected int tripleDigit;
    protected String mathSign;


    public MathGame(String gameTitle) {
        super(gameTitle);
    }

    public MathGame() {
    }


    public int getSingleDigit() {
        return singleDigit;
    }

    public void setSingleDigit(int singleDigit) {
        this.singleDigit = singleDigit;
    }

    public int getDoubleDigit() {
        return doubleDigit;
    }

    public void setDoubleDigit(int doubleDigit) {
        this.doubleDigit = doubleDigit;
    }

    public int getTripleDigit() {
        return tripleDigit;
    }

    public void setTripleDigit(int tripleDigit) {
        this.tripleDigit = tripleDigit;
    }

    public String getMathSign() {
        return mathSign;
    }

    public void setMathSign(String mathSign) {
        this.mathSign = mathSign;
    }
}
