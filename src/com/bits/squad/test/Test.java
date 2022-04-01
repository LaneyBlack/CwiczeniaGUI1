package com.bits.squad.test;

public class Test {
    public static void main(String[] args) {
        Adam adam = new Adam();
        S24382 s24382 = new S24382();
        Jarvis jarvis = new Jarvis();
        Repeater repeater = new Repeater();
        Randomizer randomizer = new Randomizer();
        Exponent exponent = new Exponent();
        AdvancedArena advancedArena = new AdvancedArena(adam, randomizer);
        advancedArena.fight(1000);
    }
}
