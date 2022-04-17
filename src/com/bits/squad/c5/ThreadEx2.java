package com.bits.squad.c5;

import static com.bits.squad.test.Colors.getTextColor;

public class ThreadEx2 extends Thread {
    private String text;
    private long counter;

    public long getCounter() {
        return counter;
    }

    public ThreadEx2(String name, String text) {
        setName(name);
        this.text = text;
        this.counter = 0;
    }

    public void run() {
        int index = 0;
        while (!isInterrupted()) {
            System.out.println(getName() + ' ' +text.charAt(index++));
            counter++;
            if (index==text.length())
                index=0;
        }

    }
}
