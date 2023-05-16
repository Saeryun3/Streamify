package com.Streamify.Model;

public enum Score {
    one_Star (1),
    two_star(2),
    three_Star(3),
    four_Star(4),
    five_Star(5);
    private int value;
    private Score(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
