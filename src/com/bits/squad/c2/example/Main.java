package com.bits.squad.c2.example;

public class Main {
    public static void main(String[] args) {
        Sprzatacz s = new Sprzatacz("Adam", 20);
        Ksiegowy k = new Ksiegowy("Adam", 25);
//        APracownik aPracownik = new APracownik();
        IPracownik [] tab = {s,k};
        System.out.println(tab[0]);
        System.out.println(tab[1]);
        //Klasa Anonimowa
        IPracownik pracownik = new IPracownik(){
            @Override
            public double getPensja() {
                return 3000;
            }
            @Override
            public String getName() {
                return "Jarek";
            }
        };


    }
}
