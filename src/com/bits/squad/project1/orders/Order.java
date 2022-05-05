package com.bits.squad.project1.orders;

import com.bits.squad.project1.Dish;

import java.util.ArrayList;

public abstract class Order {
    ArrayList<Dish> dishes;
    boolean isLate;
    long timestamp;

    public Order(ArrayList<Dish> dishes) {
        this.dishes = dishes;
        isLate = false;
        timestamp = System.currentTimeMillis();
    }
}
