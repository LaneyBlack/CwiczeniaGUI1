package com.bits.squad.test;

import java.util.ArrayList;

public class Jupiter implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    //myStats
    int strategy;
    double myEmaPrevious = 1;
    int lossCount;
    int tieCount;
    //lists
    ArrayList<Integer> enemyMoves;
    ArrayList<Integer> enemyFakes;
    ArrayList<Integer> myMoves;
    ArrayList<Integer> myFakes;
    //enemy stats
    int[] usage;
    boolean canRepeat;
    boolean fakesAreAlwaysTrue;
    boolean fakesAreAlwaysFalse;
    boolean usesEma = false;

    @Override
    public String name() {
        return "Adam";
    }

    public Jupiter() {
        strategy = 2;
        lossCount = 0;
        tieCount = 0;
        enemyMoves = new ArrayList<>();
        enemyFakes = new ArrayList<>();
        myMoves = new ArrayList<>();
        myFakes = new ArrayList<>();
        fakesAreAlwaysTrue = false;
        fakesAreAlwaysFalse = false;
        usage = new int[]{0, 0, 0};
    }

    @Override
    public int fake() {
        int myFake;
        if (enemyFakes.size() < 3)
            myFake = 1;
        else if (enemyMoves.size() < 10)
            myFake = 2;
        else
            myFake = enemyFakes.get(enemyFakes.size() - 9);
        myFakes.add(myFake);
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
                default -> myMove;
                case 1 -> fake == 2 ? offence(3) : offence(2);
                case 2 -> fake == 1 ? offence(3) : offence(1);
                case 3 -> fake == 2 ? offence(1) : offence(2);
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
        } else if (strategy == 3) {
        }
        System.out.println("Adam final move " + myMove);
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
        if (enemyMove == myMoves.get(myMoves.size()-1))
            tieCount++;
        if (!canRepeat && enemyMoves.size() > 1 && enemyMoves.get(enemyMoves.size() - 2) == enemyMoves.get(enemyMoves.size() - 1)) //if he can repeat
            canRepeat = true;
        //update EMA
        double ema = myEmaPrevious + 0.2 * (enemyMove - myEmaPrevious);
        myEmaPrevious = ema;
        System.out.println("Adam ema = " + ema);
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
        if (!score &&
                (enemyMoves.get(enemyMoves.size() - 1) != myMoves.get(myMoves.size() - 1)
                        || lossCount >= (myMoves.size() -tieCount) / 2)) {
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
