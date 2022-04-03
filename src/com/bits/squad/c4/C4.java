package com.bits.squad.c4;

import com.bits.squad.c4.ex4.CountingList;
import com.bits.squad.c4.ex5.Car;
import com.bits.squad.c4.ex5.Person;
import com.bits.squad.c4.ex6.Calc;
import com.bits.squad.test.Colors;

import java.util.*;

import static java.util.Arrays.asList;

public class C4 {
    public static void main(String[] args) {
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex1-------------------------------------" + Colors.getTextColor("RESET"));
        ArrayList<String> arrayList = new ArrayList(); // java documentation Array List
        String text = "Ala ma Kota a Kot ma Ale";
        arrayList.addAll(asList(text.split(" ")));
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        arrayList.stream().map(String::toUpperCase).filter(val -> val.endsWith("A")).forEach(val -> System.out.print(val + " "));
        System.out.println();
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex2-------------------------------------" + Colors.getTextColor("RESET"));
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i < 13; i++)
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12:
                    hashSet.add(31);
                    break;
                case 2:
                    hashSet.add(28);
                    break;
                case 4, 6, 9, 11:
                    hashSet.add(30);
                    break;
            }
        System.out.println(hashSet);
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex3-------------------------------------" + Colors.getTextColor("RESET"));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i < 13; i++)
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12:
                    hashMap.put(i, 31);
                    break;
                case 2:
                    hashMap.put(i, 28);
                    break;
                case 4, 6, 9, 11:
                    hashMap.put(i, 30);
                    break;
            }
        System.out.println("March " + hashMap.get(3));
        System.out.println(hashMap);
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex4-------------------------------------" + Colors.getTextColor("RESET"));
        CountingList countingList = new CountingList();
        countingList.add("ala ma kota");
        countingList.add("kot");
        countingList.add("Yellow");
        System.out.println(countingList.get(1));
        System.out.println(countingList.get(3));
        System.out.println(countingList.count(2));
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex5-------------------------------------" + Colors.getTextColor("RESET"));
        Car bmw = new Car("BMW", "WA12690");
        Car volvo = new Car("Volvo", "KR60606");
        Car skoda1 = new Car("Skoda", "WA00001");
        Car skoda2 = new Car("Skoda", "SC36010");
        Car mazda1 = new Car("Mazda", "WA01234");
        Car mazda2 = new Car("Mazda", "DW01ASD");

        Person kowalski = new Person("Jan", "Kowalski");
        Person nowak = new Person("Adam", "Nowak");
        Person krawczyk = new Person("Bartosz", "Krawczyk");
        Person heniek = new Person("Kierownik", "Heniek");

        HashMap<Person, ArrayList<Car>> personCarMap = new HashMap<>();
        personCarMap.put(kowalski, new ArrayList<> (asList(bmw, skoda1)));
        personCarMap.put(nowak, new ArrayList<> (asList(mazda2)));
        personCarMap.put(krawczyk, new ArrayList<> (asList(volvo,mazda1,skoda2)));
        personCarMap.put(heniek, new ArrayList<>());
        for (Map.Entry<Person, ArrayList<Car>> personCar:personCarMap.entrySet())
            System.out.println(personCar.getKey() + " has " + personCar.getValue());
        System.out.println(personCarMap.get(nowak).get(0));
        System.out.println(Colors.getTextColor("CYAN") + "-------------------------------------Ex6-------------------------------------" + Colors.getTextColor("RESET"));
        Calc calc = new Calc();
        System.out.println(calc.doCalc("144 + 12"));
        System.out.println(calc.doCalc("1,44 / 1,2"));
        System.out.println(calc.doCalc("11,02 * 3"));
        System.out.println(calc.doCalc("11,02 - 10,02"));
    }
}
