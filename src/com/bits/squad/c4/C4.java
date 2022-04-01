package com.bits.squad.c4;

import java.util.*;

public class C4 {
    public static void main(String[] args) {
        System.out.println("-------------------------------------Ex1-------------------------------------");
        ArrayList<String> arrayList = new ArrayList(); // java documentation Array List
        String text = "Ala ma Kota a Kot ma Ale";
        arrayList.addAll(Arrays.asList(text.split(" ")));
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        arrayList.stream().map(String::toUpperCase).filter(val->val.endsWith("A")).forEach(val->System.out.print(val + " "));
        System.out.println();
        System.out.println("-------------------------------------Ex2-------------------------------------");
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i < 13; i++)
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12:
                    hashSet.add(31);
                    break;
                case 2:
                    hashSet.add(28);
                    break;
                case 4, 6,9, 11:
                    hashSet.add(30);
                    break;
            }
        System.out.println(hashSet);
        System.out.println("-------------------------------------Ex3-------------------------------------");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 1; i < 13; i++)
            switch (i) {
                case 1, 3, 5, 7, 8, 10, 12:
                    hashMap.put(i,31);
                    break;
                case 2:
                    hashMap.put(i,28);
                    break;
                case 4, 6,9, 11:
                    hashMap.put(i,30);
                    break;
            }
        System.out.println("March " + hashMap.get(3));
        System.out.println(hashMap);
        System.out.println("-------------------------------------Ex4-------------------------------------");

    }
}
