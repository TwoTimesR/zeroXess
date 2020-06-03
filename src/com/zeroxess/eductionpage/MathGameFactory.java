package com.zeroxess.eductionpage;

public class MathGameFactory {
    public MathGame mathSign;
    public MathGame randomNumber;




    protected MathGame randomNumbers(){
        randomNumber = null;
        int min = 1;
        int max = 3;
        int range = max - min +1;
        int rand = (int)(Math.random()*range)+min;
        return randomNumber = selectNumber(rand);

    }

    private MathGame selectNumber(int rand){
        if (rand == 1){
            return new SingleDigit();
        }
        if (rand == 2){
            return new DoubleDigit();
        }
        if (rand == 3){
            return new TripleDigit();
        }
        else return null;
    }

    protected MathGame randomMathSign(){
        mathSign = null;
        int min = 1;
        int max = 4;
        int range = max - min;
        int rand = (int) (Math.random() * range) + min;
        if (rand == 1){
            return mathSign = new MathGamePlus();
        }
        if (rand == 2){
            return  mathSign = new MathGameMinus();
        }
        if (rand == 3){
            return  mathSign = new MathGameDivide();
        }
        else{
            return mathSign = new MathGameMultiply();
        }
    }

}
