package com.bits.squad.c2.classes.ex2;

public class Animal implements IAnimalBehaviors {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public void move() {
        IAnimalBehaviors.super.move();
    }

    @Override
    public void speak() {
        IAnimalBehaviors.super.speak();
    }
}
