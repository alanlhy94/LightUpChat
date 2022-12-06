package com.example.lightupchat;

public class RandomGenerate {

    private int min = 123456;
    private int max = 987654;
    private int rand = 0;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public int getRand(){
        return rand;
    }

    public void generate(){
        rand = (int)Math.floor(Math.random()*(max-min+1)+min);
    }
}
