package com.bits.squad.c3;

import com.bits.squad.c3.classes.Calculator;
import com.bits.squad.c3.classes.ICalculator;

public class C3 {
    public static void main(String[] args) {
        System.out.println("--------------------------Ex1--------------------------");
        Calculator<Float> c1 = new Calculator(1.4, 4.2);
        Calculator<Integer> c2 = new Calculator(2, 4);
        c1.calculate();
        c2.calculate();
        System.out.println("--------------------------Ex2--------------------------");
        ICalculator myAdd = (double a, double b) -> {
            return a + b;
        };
        ICalculator mySubtract = (double a, double b) -> {
            return a - b;
        };
        ICalculator myMultiply = (double a, double b) -> {
            return a * b;
        };
        ICalculator myDivide = (double a, double b) -> {
            return a / b;
        };
        System.out.println(myAdd.calculate(2.1, 3.0));
        System.out.println(mySubtract.calculate(4.1, 3.0));
        System.out.println(myMultiply.calculate(2.1, 2.0));
        System.out.println(myDivide.calculate(8.0, 3.0));
        System.out.println("--------------------------Ex3--------------------------");
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (1 + Math.random() * 100);
        }
        calculate(numbers, myAdd);
    }

    public static void calculate(int []array, ICalculator iCalc) {
        System.out.println("Before");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        System.out.println("After");
        int [] results = new int[array.length/2];
        for (int i = 0, j=0; i < array.length; i+=2, j++) {
            results[j] = (int) iCalc.calculate(array[i], array[i+1]);
            System.out.print(results[j] + " ");
        }
        System.out.println();
    }
}
