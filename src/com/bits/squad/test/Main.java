package com.bits.squad.test;

import com.bits.squad.test.classes.Singer;

public class Main {
    public static void main(String[] args) {
        Singer s1 = new Singer("Dietrich") {
            @Override
            public String sing() {
                return "oooooooooo";
            }
        };
        Singer s2 = new Singer("Piaf") {
            @Override
            public String sing() {
                return "a4iBBbiii";
            }
        };
        Singer s3 = new Singer("Adele") {
            @Override
            public String sing() {
                return "aAa";
            }
        };

        Singer sp[] = {s1, s2, s3};
        for (Singer s : sp) {
            System.out.println(s);
        }
        System.out.println("\n" + Singer.loudest(sp));
    }

}
