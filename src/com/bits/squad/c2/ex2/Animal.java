package com.bits.squad.c2.ex2;

public class Animal implements IAnimalBehaviors{
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Eating leafs");
    }

    @Override
    public void move() {
        System.out.println("Moving to another continent");
    }

    @Override
    public void speak() {
        System.out.println("Bark bark");
    }
}
