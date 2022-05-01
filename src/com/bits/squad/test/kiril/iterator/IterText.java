package com.bits.squad.test.kiril.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class IterText implements Iterable<Character> {
    private int index;
    private int step;
    private int start;
    private String text;

    public IterText(String text) {
        this.text = text;
        index = 0;
        step = 1;
        start = 0;
    }

    public String run(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < text.length() ; i+=step) {
            if (text.charAt(i)>='A' && text.charAt(i)<='Z')
                stringBuilder.append(text.toLowerCase().charAt(i) + " ");
        }
        return stringBuilder.toString();
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public Iterator iterator() {
        index = start - step;
        return new Iterator<Character>() {
            @Override
            public boolean hasNext() {
                return (index += step) < text.length();
            }
            @Override
            public Character next() {
                return text.charAt(index);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        for (int i = start; i < text.length(); i+=step)
            if (text.charAt(i)>='A' && text.charAt(i)<='Z')
                action.accept(text.toLowerCase().charAt(i));
    }
}
