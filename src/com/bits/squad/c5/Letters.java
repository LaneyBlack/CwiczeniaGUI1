package com.bits.squad.c5;

import java.util.ArrayList;

public class Letters {
    String text;
    int numberOfThreads;
    ArrayList<ThreadEx2> threads;

    public Letters(String text, int numberOfThreads) {
        this.text = text;
        this.numberOfThreads = numberOfThreads;
        threads = new ArrayList<ThreadEx2>();
        for (int i = 1; i <= numberOfThreads; i++) {
            ThreadEx2 myThread = new ThreadEx2("Number " + i, text);
            threads.add(myThread);
        }
    }

    public ArrayList<ThreadEx2> getThreads() {
        return threads;
    }
}
