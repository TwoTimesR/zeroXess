package com.zeroxess.educationpage;

public abstract class MathGame extends Game {
    protected int Digit;
    protected String mathSign;


    public MathGame() {
        super("Math Game");
    }

    public int getDigit() {
        return Digit;
    }

    public void setDigit(int digit) {
        Digit = digit;
    }

    public String getMathSign() {
        return mathSign;
    }

    public void setMathSign(String mathSign) {
        this.mathSign = mathSign;
    }
}
