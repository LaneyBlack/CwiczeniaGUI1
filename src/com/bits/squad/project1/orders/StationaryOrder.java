package com.bits.squad.project1.orders;

import com.bits.squad.project1.Dish;

import java.util.ArrayList;

public class StationaryOrder extends Order{
    private byte tableNumber;

    public StationaryOrder(ArrayList<Dish> dishes, byte tableNumber) {
        super(dishes);
        this.tableNumber = tableNumber;
    }
}
