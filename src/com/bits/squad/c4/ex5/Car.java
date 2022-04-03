package com.bits.squad.c4.ex5;

public class Car {
    private String model;
    private String registrationNumber;

    public Car(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return model + " RegPlate:" + registrationNumber;
    }
}
