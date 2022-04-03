package com.bits.squad.test.arena;

import java.util.ArrayList;

public class Jarvis implements IAdvancedGamer {
    //Rock 1, Paper 2, Scissors 3
    int strategy;
    int lossCount;
    int stepToRepeat;
    ArrayList<Integer> enemyMoves;
    ArrayList<Integer> enemyFakes;
    ArrayList<Integer> myMoves;
    ArrayList<Integer> myFakes;
    ArrayList<Boolean> winLossList;
    boolean canRepeat;
    boolean hasLoop;
    boolean fakesAreAlwaysTrue;
    boolean fakesAreAlwaysFalse;

    @Override
    public String name() {
        return "Jarvis";
    }

    public Jarvis() {
        strategy = 1;
        lossCount = 0;
        stepToRepeat = 0;
        enemyMoves = new ArrayList<>();
        enemyFakes = new ArrayList<>();
        myMoves = new ArrayList<>();
        myFakes = new ArrayList<>();
        winLossList = new ArrayList<>(100);
        fakesAreAlwaysTrue = false;
        fakesAreAlwaysFalse = false;
    }

    @Override
    public int fake() {
        int myFake;
        if (enemyFakes.isEmpty())
            myFake = 1;
        else
            myFake = enemyFakes.get(enemyFakes.size() - 1);
        myFakes.add(myFake);
        return myFake;
    }

    @Override
    public int play(int fake) {
        int myMove = 2;
        enemyFakes.add(fake);
        if (fakesAreAlwaysTrue) {
            myMove = offence(fake);
        } else if (fakesAreAlwaysFalse && !canRepeat && fake != enemyMoves.get(enemyMoves.size() - 1)) {
            myMove = switch (enemyMoves.get(enemyMoves.size() - 1)) {
                case 1 -> fake == 2 ? offence(3) : offence(2);
                case 2 -> fake == 1 ? offence(3) : offence(1);
                case 3 -> fake == 2 ? offence(1) : offence(2);
                default -> myMove;
            };
        } else if (strategy == 1) { //Default strategy. Just counting the less used option, and
            double[] frequency = {0, 0, 0};
            if (!enemyMoves.isEmpty()) {
                for (int val : enemyMoves)
                    if (val == 1)
                        frequency[0]++;
                    else if (val == 2)
                        frequency[1]++;
                    else if (val == 3)
                        frequency[2]++;
                for (int i = 0; i < frequency.length; i++) {
                    frequency[i] /= enemyMoves.size();
                }
                if (frequency[0] - frequency[1] > 0.2 || frequency[1] - frequency[2] > 0.2 || frequency[0] - frequency[2] > 0.2) {
                    //       rock usage     paper usage    rock usage     scissors usage r   s   paper usage   scissors usage  p   s
                    myMove = frequency[0] > frequency[1] ? frequency[0] > frequency[2] ? offence(1) : offence(3) : frequency[1] > frequency[2] ? offence(2) : offence(3);
                    if (fakesAreAlwaysFalse)
                        myMove = offenceOnFrequency(myMove, fake, frequency);
                } else if (!canRepeat) {
                    myMove = offenceOnFrequency(myMove, enemyMoves.get(enemyMoves.size() - 1), frequency);
                }
            }
        } else if (strategy == 2) {
        } else if (strategy == 3) {  //he repeats my moves
            int enemyMove = myMoves.get(myMoves.size() - 1);
            myMove = offence(enemyMove);
        }
        myMoves.add(myMove);
        return myMove;
    }

    @Override
    public void result(boolean score, int enemyMove) {
        enemyMoves.add(enemyMove);
        winLossList.add(score);
        if (!canRepeat && enemyMove == enemyMoves.get(enemyMoves.size() - 1))
            canRepeat = true;
        if (winLossList.size() == 100) {
            int wins = 0, losses = 0;
            for (boolean win : winLossList) {
                if (win)
                    wins++;
                else
                    losses++;
            }
            winLossList = new ArrayList<>(100);
            if (losses > wins) { // should change strategy
                //check for fakes
                int matchCounter = 0;
                for (int i = enemyMoves.size() - 100; i < enemyMoves.size(); i++)
                    if (enemyMoves.get(i).equals(enemyFakes.get(i)))
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
                //check for repeating my moves
                matchCounter = 0;
                for (int k = 1; k <= 10; k++) {
                    for (int i = enemyMoves.size() + k - 100; i < enemyMoves.size(); i++) { //check for using my moves in last 100 fights
                        if (enemyMoves.get(i) == myMoves.get(i - k))
                            matchCounter++;
                    }
                    if (matchCounter == 100 - k) {
                        stepToRepeat = k;
                        strategy = 3;
                    }
                }
//                if (enemyMoves.size() > 30) {
//                    for (int k = 1; k <= 10; k++) {
//                        matchCounter = 0;
//                        for (int i = enemyMoves.size() - 10; i < enemyMoves.size(); i++) //check for using my moves in last 100 fights
//                            if (enemyMoves.get(i) == myMoves.get(i - k))
//                                if (myMoves.get(i-k)!=myMoves.get(i-k-1)&&myMoves.get(i-k)!=myMoves.get(i-k-10))
//                                    matchCounter++;
//                                else
//                                    break;
//                        if (matchCounter == 10) {
//                            stepToRepeat = k;
//                            strategy = 3;
//                            System.out.println("Strategy = 3, stepToRepeat = " + stepToRepeat);
//                            //this break fixes if step < 10. If step > 10 he ruins algorithm :(
//                            break;
//                        } else
//                            strategy = 1;
//                    }
//                }
            }
        }
//        if (score)
//            lossCount = 0;
//        else {
//            lossCount++;
//            if (lossCount > 200)
//                strategy = 2;
//            if (lossCount > 300)
//                strategy = 3;
//        }
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
