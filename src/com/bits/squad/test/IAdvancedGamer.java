package com.bits.squad.test;

import com.bits.squad.c2.classes.ex5.IGamer;

public interface IAdvancedGamer {
    String name();
    int fake();
    int play(int fake);
    void result(boolean score, int enemyMove);
}
