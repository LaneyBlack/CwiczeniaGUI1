package com.bits.squad.c4;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class CountingList {
    private static int index;
    void add(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += string.charAt(i);
        }
    }
    void get (int index) {
    }

}

