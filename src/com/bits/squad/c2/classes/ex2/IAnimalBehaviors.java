package com.bits.squad.c2.classes.ex2;

public interface IAnimalBehaviors extends IMove, ISpeak {
    @Override
    default void move() {
        System.out.println("Moving...");
    }

    @Override
    default void speak() {
        System.out.println("Speaking english :)");
    }
}
