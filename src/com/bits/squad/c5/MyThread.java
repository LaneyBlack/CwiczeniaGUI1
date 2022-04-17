package com.bits.squad.c5;

public class MyThread extends Thread{
    public void run(){
        System.out.println("Thread starting");
        for (int i = 0; i < 2000000; i++) {
            String a = "a";
            String b = "b";
            String c = a+b;
        }
        System.out.println("Thread ending");
    }
}
