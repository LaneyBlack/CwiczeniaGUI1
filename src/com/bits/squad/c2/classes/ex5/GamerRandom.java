package com.bits.squad.c2.classes.ex5;

public class GamerRandom implements IGamer{

    @Override
    public int play() {
        return 1 + (int)(Math.random()*3);
    }

    @Override
    public String name() {
        return "Random Gamer";
    }
}
