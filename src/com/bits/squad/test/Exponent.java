package com.bits.squad.test;

import java.util.ArrayList;

public class Exponent implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    ArrayList<Integer> enemyFakes;
    double emaPrevious = 1;

    @Override
    public String name() {
        return "Exponent";
    }

    public Exponent() {
        enemyFakes = new ArrayList<>();
    }

    @Override
    public int fake() {
        int myFake;
        if (enemyFakes.isEmpty())
            myFake = 1;
        else
            myFake = enemyFakes.get(enemyFakes.size() - 1);
        return myFake;
    }

    @Override
    public int play(int fake) {
//        System.out.println( "Expodent move" + offence((int)Math.round(emaPrevious)));
        return offence((int)Math.round(emaPrevious));
    }

    @Override
    public void result(boolean score, int enemyMove) {
        double ema = emaPrevious + 0.2*(enemyMove-emaPrevious);
        emaPrevious = ema;
        System.out.println( "ema = " + ema);
    }

    private int offence(int enemyMove) {
        return enemyMove == 1 ? 2 : enemyMove == 2 ? 3 : 1;
    }

    private int offenceOnFrequency(int myMove, int expectedEnemyMove, double[] frequency) {
        myMove = switch (expectedEnemyMove) {
            case 1 -> frequency[1] > frequency[2] ? offence(2) : offence(3);
            case 2 -> frequency[0] > frequency[2] ? offence(1) : offence(3);
            case 3 -> frequency[0] > frequency[1] ? offence(1) : offence(2);
            default -> myMove;
        };
        return myMove;
    }
}
