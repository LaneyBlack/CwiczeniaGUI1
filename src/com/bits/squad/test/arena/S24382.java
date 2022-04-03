package com.bits.squad.test.arena;

import java.util.ArrayList;

public class S24382 implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    //myStats
    private int strategy;
    private double myEmaPrevious = 1;
    private int lossCount;
    private int tieCount;
    //lists
    private ArrayList<Integer> enemyMoves;
    private ArrayList<Integer> enemyFakes;
    private ArrayList<Integer> myMoves;
    //enemy stats
    private int[] usage;
    private boolean canRepeat;
    private boolean fakesAreAlwaysTrue;
    private boolean fakesAreAlwaysFalse;

    @Override
    public String name() {
        return "s24382";
    }

    public S24382() {
        strategy = 1;
        lossCount = 0;
        tieCount = 0;
        enemyMoves = new ArrayList<>();
        enemyFakes = new ArrayList<>();
        myMoves = new ArrayList<>();
        fakesAreAlwaysTrue = false;
        fakesAreAlwaysFalse = false;
        usage = new int[]{0, 0, 0};
    }

    @Override
    public int fake() {
        int myFake;
        if (enemyFakes.size() > 2)
            myFake = enemyFakes.get(enemyFakes.size() - 2);
        else if (enemyFakes.size() < 1)
            myFake = 1;
        else
            myFake = 2;
        return myFake;
    }

    @Override
    public int play(int fake) {
        int myMove = 2;
        enemyFakes.add(fake);
        if (fakesAreAlwaysTrue) {
            myMove = offence(fake);
        } else if (fakesAreAlwaysFalse && !canRepeat && fake != enemyMoves.get(enemyMoves.size() - 1) && enemyMoves.size() > 10) {
            myMove = switch (enemyMoves.get(enemyMoves.size() - 1)) {
                case 1 -> fake == 2 ? offence(3) : offence(2);
                case 2 -> fake == 1 ? offence(3) : offence(1);
                case 3 -> fake == 2 ? offence(1) : offence(2);
                default -> myMove;
            };
        } else if (strategy == 1) { //Default strategy. Just counting the most used option.
            if (!enemyMoves.isEmpty()) {
                double[] frequency = {0, 0, 0};
                for (int i = 0; i < frequency.length; i++) {
                    frequency[i] += usage[i];
                    frequency[i] /= enemyMoves.size();
                }
                //       rock usage     paper usage    rock usage     scissors usage r   s   paper usage   scissors usage  p   s
                myMove = frequency[0] > frequency[1] ? frequency[0] > frequency[2] ? offence(1) : offence(3) : frequency[1] > frequency[2] ? offence(2) : offence(3);
                if (fakesAreAlwaysFalse) {
                    myMove = offenceOnFrequency(myMove, fake, frequency);
                } else if (!canRepeat) {
                    myMove = offenceOnFrequency(myMove, enemyMoves.get(enemyMoves.size() - 1), frequency);
                }
            }
        } else if (strategy == 2) {
            myMove = offence((int) Math.round(myEmaPrevious));
        }
        myMoves.add(myMove);
        return myMove;
    }

    @Override
    public void result(boolean score, int enemyMove) {
        enemyMoves.add(enemyMove);
        if (enemyMove == 1)
            usage[0]++;
        else if (enemyMove == 2)
            usage[1]++;
        else if (enemyMove == 3)
            usage[2]++;

        if (!score && enemyMove == myMoves.get(myMoves.size() - 1))
            tieCount++;
        else if (!score)
            lossCount++;

        if (!canRepeat && enemyMoves.size() > 1 && enemyMoves.get(enemyMoves.size() - 2) == enemyMoves.get(enemyMoves.size() - 1)) //if he can repeat
            canRepeat = true;
        //update EMA
        double ema = myEmaPrevious + 0.2 * (enemyMove - myEmaPrevious);
        myEmaPrevious = ema;
        //check for fakes
        int matchCounter = 0;
        for (int i = 0; i < enemyMoves.size(); i++)
            if (enemyMoves.get(i) == enemyFakes.get(i))
                matchCounter++;
        if (matchCounter == enemyMoves.size()) {
            fakesAreAlwaysFalse = false;
            fakesAreAlwaysTrue = true;
        } else if (matchCounter == 0) {
            fakesAreAlwaysFalse = true;
            fakesAreAlwaysTrue = false;
        } else {
            fakesAreAlwaysFalse = false;
            fakesAreAlwaysTrue = false;
        }
        if (!score && (enemyMoves.get(enemyMoves.size() - 1) != myMoves.get(myMoves.size() - 1) || lossCount >= (myMoves.size() - tieCount) / 2)) {
            // then I should change strategy
            strategy = strategy == 2 ? 1 : 2;
        }
    }

    private int offence(int enemyMove) {
        return enemyMove == 1 ? 2 : enemyMove == 2 ? 3 : 1;
    }

    private int offenceOnFrequency(int myMove, int expectedEnemyMove, double[] frequency) {
        return switch (expectedEnemyMove) {
            case 1 -> frequency[1] > frequency[2] ? offence(2) : offence(3);
            case 2 -> frequency[0] > frequency[2] ? offence(1) : offence(3);
            case 3 -> frequency[0] > frequency[1] ? offence(1) : offence(2);
            default -> myMove;
        };
    }
}
