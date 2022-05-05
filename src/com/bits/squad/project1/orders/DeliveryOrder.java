package com.bits.squad.project1.orders;

import com.bits.squad.project1.Dish;

import java.util.ArrayList;

public class DeliveryOrder extends Order{
    private String address;

    public DeliveryOrder(ArrayList<Dish> dishes, String address) {
        super(dishes);
        this.address = address;
    }
}
