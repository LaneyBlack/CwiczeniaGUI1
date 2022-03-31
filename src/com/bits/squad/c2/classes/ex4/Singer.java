package com.bits.squad.c2.classes.ex4;

public abstract class Singer {
    private static int index = 0;
    private String name;
    private final int number;

    public Singer(String name) {
        this.name = name;
        number = ++index;
    }

    public String sing() {
        return " ";
    }

    public static Singer loudest(Singer[] sp) {
        int loudestIndex = 0;
        for (int i = 0; i < sp.length; i++) {
            if (getUniques(sp[i].sing()) > getUniques(sp[loudestIndex].sing()))
                loudestIndex = i;
        }
        return sp[loudestIndex];
    }

    public static int getUniques(String string) {
        int matches = 0;
        for (int i = 0; i < string.length();) {
            char letter = string.charAt(i);
            if (letter > 65 && letter < 90) { //Capital letters
                string = string.replaceAll(String.valueOf(letter), "");
                matches++;
            }
            string = string.replaceAll(String.valueOf(letter), "");
        }
        return matches;
    }

    @Override
    public String toString() {
        return " (" + number + ") " + name + ":" + sing();
    }
}
