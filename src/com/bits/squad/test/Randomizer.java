package com.bits.squad.test;

import java.util.ArrayList;

public class Randomizer implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    ArrayList<Integer> enemyFakes = new ArrayList<>();

    @Override
    public String name() {
        return "Randomizer";
    }

    @Override
    public int fake() {
        if (enemyFakes.isEmpty()) {
            return 1;
        } else {
            return enemyFakes.get(enemyFakes.size() - 1);
        }
    }

    @Override
    public int play(int fake) {
        int rnd = 1 + (int)(Math.random()*3);
        System.out.println( "Random: " + rnd);
        return rnd;
    }

    @Override
    public void result(boolean score, int enemyMove) {
    }
}
