package com.bits.squad.c4.ex4;

public class Element {
    private int index;
    private String value;
    private int sum;
    private Element next;

    public Element(int index, String value, int sum) {
        this.index = index;
        this.value = value;
        this.sum = sum;
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
    public int getSum() {
        return sum;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}
