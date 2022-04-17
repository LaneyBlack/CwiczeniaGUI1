package com.bits.squad.c5;

public class ThreadEx1 extends Thread{

    public ThreadEx1(String name) {
        super(name);
    }

    public void run(){
        for (int i = 0; i < 11; i++) {
            System.out.println(super.getName() + " " + i);
        }
    }
}
