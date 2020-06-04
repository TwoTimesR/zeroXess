package com.zeroxess.educationpage;

public class MathGameFactory {
    public MathGame number;

    public MathGame mathSign;

    public MathGame makeNumber(){
        number = null;
       int rand = threeRandomGen();
        return selectDigit(rand);
    }

    private int threeRandomGen(){
        int min = 1;
        int max = 3;
        int range = max -min + 1;
        return ((int)(Math.random()*range)+min);
    }

    private MathGame selectDigit(int rand){
        if (rand ==1){
            return new MathGameSingleDigit();
        }
        if (rand ==2){
            return  new MathGameDoubleDigit();
        }
        else return new MathGameTripleDigit();
    }

    public MathGame makeMathSign(){
        mathSign = null;
        return selectMath(threeRandomGen());
    }

    private MathGame selectMath(int rand){
        if (rand == 1){
            return new MathGamePlus();
        }
        if (rand == 3){
            return  new MathGameMinus();
        }
        else return new MathGameMultiply();
    }

}
