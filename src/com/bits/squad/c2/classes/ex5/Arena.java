package com.bits.squad.c2.classes.ex5;

public class Arena {
    // Rock 1, Paper 2, Scissors 3
    private IGamer gamer1;
    private IGamer gamer2;

    public Arena(IGamer gamer1, IGamer gamer2) {
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
    }

    public void fight(int numberOfRounds) {
        int winCounterGamer1 = 0, winCounterGamer2 = 0;
        int objectGamer1, objectGamer2;
        for (int i = 0; i <= numberOfRounds; i++) {
            System.out.println("Round " + i + ":");
            objectGamer1 = gamer1.play();
            objectGamer2 = gamer2.play();
            if (objectGamer1 == objectGamer2)
                System.out.println("Draw!");
            else if (objectGamer1 == 1)
                if (objectGamer2 == 2) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
                    winCounterGamer1++;
                }
            else if (objectGamer1 == 2)
                if (objectGamer2 == 3) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
                    winCounterGamer1++;
                }
            else if (objectGamer1 == 3)
                if (objectGamer2 == 1) {
                    System.out.println("Player " + gamer2.name() + " wins!");
                    winCounterGamer2++;
                } else {
                    System.out.println("Player " + gamer1.name() + " wins!");
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