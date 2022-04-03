package com.bits.squad.test.arena;

import java.util.ArrayList;

public class Repeater implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    ArrayList<Integer> enemyMoves = new ArrayList<>();
    ArrayList<Integer> enemyFakes = new ArrayList<>();

    @Override
    public String name() {
        return "Repeater";
    }

    @Override
    public int fake() {
        if (enemyFakes.isEmpty()) {
            return 1;
        } else{
            return enemyFakes.get(enemyFakes.size() - 1);
        }
    }

    @Override
    public int play(int fake) {
        enemyFakes.add(fake);
        int step = 1;
        if (enemyMoves.size()<step)
            return 1;
        else {
            return enemyMoves.get(enemyMoves.size()-step);
        }
    }

    @Override
    public void result(boolean score, int enemyMove) {
        enemyMoves.add(enemyMove);
    }
}
