package com.bits.squad.test;

import com.bits.squad.c2.classes.ex5.IGamer;

public class AdvancedArena {
    // Rock 1, Paper 2, Scissors 3
    private IAdvancedGamer gamer1;
    private IAdvancedGamer gamer2;

    public AdvancedArena(IAdvancedGamer gamer1, IAdvancedGamer gamer2) {
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
    }

    public void fight(int numberOfRounds) {
        int winCounterGamer1 = 0, winCounterGamer2 = 0;

        for (int i = 1; i <= numberOfRounds; i++) {
            int objectGamer1, objectGamer2, fakeGamer1, fakeGamer2;
            System.out.println("Round " + i + ":");
            fakeGamer1=gamer1.fake();
            fakeGamer2=gamer2.fake();
            objectGamer1 = gamer1.play(fakeGamer2);
            objectGamer2 = gamer2.play(fakeGamer1);
            if (objectGamer1 == objectGamer2) {
                System.out.println("Draw!");
                gamer1.result(false, objectGamer2);
                gamer2.result(false, objectGamer1);
            } else if (objectGamer1 == 1)
                if (objectGamer2 == 2) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    gamer1.result(false, objectGamer2);
                    gamer2.result(true, objectGamer1);
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
                    gamer1.result(true, objectGamer2);
                    gamer2.result(false, objectGamer1);
                    winCounterGamer1++;
                }
            else if (objectGamer1 == 2)
                if (objectGamer2 == 3) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    gamer2.result(true, objectGamer1);
                    gamer1.result(false, objectGamer2);
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
                    gamer1.result(true, objectGamer2);
                    gamer2.result(false, objectGamer1);
                    winCounterGamer1++;
                }
            else if (objectGamer1 == 3)
                if (objectGamer2 == 1) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    gamer2.result(true, objectGamer1);
                    gamer1.result(false, objectGamer2);
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
                    gamer1.result(true, objectGamer2);
                    gamer2.result(false, objectGamer1);
                    winCounterGamer1++;
                }
            System.out.println("-----");
        }
        System.out.println("Result after " + numberOfRounds + " rounds");
        System.out.println("Player " + gamer2.name() + " wins: " + winCounterGamer2);
        System.out.println("Player " + gamer1.name() + " wins: " + winCounterGamer1);
        if (winCounterGamer1==winCounterGamer2)
            System.out.println("Arena result: Tie");
        else if (winCounterGamer1 > winCounterGamer2)
            System.out.println("Arena result: " + gamer1.name() + " wins!");
        else
            System.out.println("Arena result: " + gamer2.name() + " wins!");
    }
}
