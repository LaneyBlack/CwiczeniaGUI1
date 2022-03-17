package com.bits.squad.c1.classes;

public class Hero {
    private String name;
    private int age;

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sayHelloTo(Hero hero){
        System.out.println("Hi " + hero.getName() + "!");
    }
}
