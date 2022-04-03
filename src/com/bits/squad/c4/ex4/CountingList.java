package com.bits.squad.c4.ex4;

import static com.bits.squad.test.Colors.getTextColor;

public class CountingList {
    private static int length = 0;
    private Element head;

    public void add(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += string.charAt(i);
        }
        if (head != null) {
            Element tmp = head;
            while (tmp.getNext() != null)
                tmp = tmp.getNext();
            tmp.setNext(new Element(++length, string, sum));
        } else {
            head = new Element(length = 0, string, sum);
        }
    }

    public int count(int index) {
        if (index >= length + 1) {
            System.out.println(getTextColor("Yellow") + "Index out of Bounds!" + getTextColor("Reset"));
            return -1;
        } else {
            Element tmp = head;
            while (tmp.getIndex() != index)
                tmp = tmp.getNext();
            return tmp.getSum();
        }
    }

    public String get(int index) {
        if (index >= length + 1) {
            System.out.print(getTextColor("Yellow") + "Index out of Bounds!" + getTextColor("Reset"));
            return "";
        } else {
            Element tmp = head;
            while (tmp.getIndex() != index)
                tmp = tmp.getNext();
            return tmp.getValue();
        }
    }

}

