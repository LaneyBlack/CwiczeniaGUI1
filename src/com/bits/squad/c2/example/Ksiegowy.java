package com.bits.squad.c2.example;

public class Ksiegowy extends APracownik{
    double amountOfBook;

    public Ksiegowy(String name, double amountOfBook) {
        super(name);
        this.amountOfBook = amountOfBook;
    }

    @Override
    public double getPensje() {
        return 1000+amountOfBook*20;
    }
}
