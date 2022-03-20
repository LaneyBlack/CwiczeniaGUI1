package com.bits.squad.c2.ex1;

public class Square implements Comparable<Square> {
    private int length;
    private int number;
    static int counter = 0;

    public Square(int length) {
        this.length = length;
        number = ++counter;
    }

    @Override
    public String toString() {
        return "Square{ number = " + number + ", area = " + getArea() +
                '}';
    }

    public int getArea() {
        return length * length;
    }

    @Override
    public int compareTo(Square square) {
        return getArea() > square.getArea() ? 1 : -1;
    }
}
