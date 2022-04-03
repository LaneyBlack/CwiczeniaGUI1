package com.bits.squad.c4.ex6.operations;

import com.bits.squad.c3.classes.ICalculator;

public class Divide implements ICalculator {
    @Override
    public double calculate(double a, double b) {
        return a/b;
    }
}
