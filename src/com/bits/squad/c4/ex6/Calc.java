package com.bits.squad.c4.ex6;

import com.bits.squad.c3.classes.ICalculator;
import com.bits.squad.c4.ex6.operations.Divide;
import com.bits.squad.c4.ex6.operations.Multiply;
import com.bits.squad.c4.ex6.operations.Subtract;
import com.bits.squad.c4.ex6.operations.Summary;

import java.util.HashMap;

import static com.bits.squad.test.Colors.getTextColor;

public class Calc {
    HashMap<Character, ICalculator> operations = new HashMap<>();

    public Calc() {
        operations.put('*', new Multiply());
        operations.put('/', new Divide());
        operations.put('-', new Subtract());
        operations.put('+', new Summary());
    }

    public double doCalc(String operation) {
        String[] parts = operation.trim().split(" ", 3);
        double a = 0, b = 0;
        a = stringToDouble(parts[0]);
        b = stringToDouble(parts[2]);
        return operations.get(parts[1].charAt(0)).calculate(a, b);
    }

    public double stringToDouble(String number) {
        double a = 0;
        String[] split = number.split(",");
        for (int i = split[0].length() - 1, x = 0; i >= 0; i--, x++) //before '.'
            if (split[0].charAt(i) >= '0' && split[0].charAt(i) <= '9')
                a += (split[0].charAt(i) - '0') * (Math.pow(10, x));
            else {
                dropException();
                break;
            }
        if (split.length > 1)
            for (int i = 0; i < split[1].length(); i++) //after '.'
                if (split[1].charAt(i) >= '0' && split[1].charAt(i) <= '9')
                    a += (split[1].charAt(i) - '0') * (Math.pow(0.1, i+1));
                else {
                    dropException();
                    break;
                }
        return a;
    }

    public void dropException() {
        System.out.println(getTextColor("Red") + "Entry numbers are bad. Please reload the application." + getTextColor("Reset"));
    }
}
