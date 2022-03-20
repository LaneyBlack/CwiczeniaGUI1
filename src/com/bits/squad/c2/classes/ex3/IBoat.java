package com.bits.squad.c2.classes.ex3;

public interface IBoat {
    default void move(){
        System.out.println("Moving on water.");
    }
}
