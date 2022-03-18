package com.bits.squad.c2.example;

public abstract class APracownik implements IPracownik {
    String name;

    public APracownik(String name) {
        this.name = name;
    }

    @Override
    public double getPensja() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract double getPensje();
}
