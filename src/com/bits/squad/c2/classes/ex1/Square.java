package com.bits.squad.c2.classes.ex1;

public class Square implements Comparable<Square> {
    private int length;
    private int number;
    private static int counter = 0;

    public Square(int length) {
        this.length = length;
        number = ++counter;
    }

    public int getArea () {
        return length*length;
    }

    @Override
    public String toString() {
        return "Square{" + "area=" + getArea() + ", number=" + number + '}';
    }

    @Override
    public int compareTo(Square o) {
        return Integer.compare(getArea(), o.getArea());
    }
}
