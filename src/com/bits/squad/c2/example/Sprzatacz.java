package com.bits.squad.c2.example;

public class Sprzatacz extends APracownik {
    double area;

    public Sprzatacz(String name, double area) {
        super(name);
        this.area = area;
    }

    @Override
    public double getPensje() {
        return 12_000+area*50;
    }
}
