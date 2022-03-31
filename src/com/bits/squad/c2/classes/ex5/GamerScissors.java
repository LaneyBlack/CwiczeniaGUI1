package com.bits.squad.c2.classes.ex5;

public class GamerScissors implements IGamer{
    @Override
    public int play() {
        return 3;
    }

    @Override
    public String name() {
        return "Scissors Gamer";
    }
}
