package com.bits.squad.c2.ex3;

public class Amphibious implements IBoat, IAuto{
    String name;

    public Amphibious(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        IBoat.super.move();
    }
}
