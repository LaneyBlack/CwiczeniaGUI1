package com.bits.squad.c3.classes;

public class Calculator <T extends Number>{
    T value1;
    T value2;

    public Calculator(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void calculate() {
        System.out.println(value1.doubleValue()*value2.doubleValue());
    }
}
