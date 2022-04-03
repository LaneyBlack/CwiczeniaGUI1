package com.bits.squad.test.iterator;

public class IterTextTest {
    public static void main(String[] args) {
        IterText text = new IterText("prOgrAmoWanIe ObiEktOwe i Gui");
        for (char z: text)
            System.out.print(z + " ");
        System.out.println();
        text.setStart(2);
        text.setStep(3);
        for (char z: text)
            System.out.print(z + " ");
        System.out.println();
        text.forEach(x-> System.out.print(x + " "));
    }
}
