package com.bits.squad.c2.classes.ex3;

public class Amphibious implements IBoat, IAuto {
    private String name;

    public Amphibious(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        System.out.println("Moving on water and ground.");
    }
}
