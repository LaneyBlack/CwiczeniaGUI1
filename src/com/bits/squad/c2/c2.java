package com.bits.squad.c2;

import com.bits.squad.c2.ex1.Square;
import com.bits.squad.c2.ex2.Animal;
import com.bits.squad.c2.ex3.Amphibious;
import com.bits.squad.c2.ex3.Auto;
import com.bits.squad.c2.ex3.Boat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c2 {
    public static void main(String[] args) {
        System.out.println("--------------------------------Ex1--------------------------------");
        Square square1 = new Square(10);
        Square square2 = new Square(2);
        Square square3 = new Square(5);
        Square square4 = new Square(7);
        Square square5 = new Square(20);
        ArrayList<Square> list = new ArrayList<>();
        list.add(square1);
        list.add(square2);
        list.add(square3);
        list.add(square4);
        list.add(square5);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println("--------------------------------Ex2--------------------------------");
        Animal animal = new Animal("Dog");
        animal.eat();
        animal.move();
        animal.speak();
        System.out.println("--------------------------------Ex3--------------------------------");
        Auto auto = new Auto("BMW");
        Boat boat = new Boat("Shark");
        Amphibious amphibious = new Amphibious("Amphi");
        auto.move();
        boat.move();
        amphibious.move();
    }
}
