package com.java;

import java.io.IOException;
import java.util.LinkedList;

public class AmazingFourDigit_6679 {
    public static void main(String[] args) throws IOException {
        for (int i = 1000; i < 10000; i++) {
            char[] Ten = Integer.toString(i).toCharArray();
            int Tensum = 0;
            for (int j = 0; j < Ten.length; j++) {
                Tensum += Integer.parseInt(String.valueOf(Ten[j]));
            }
            char[] Twv = change(i, 12).toCharArray();
            int Twvsum = 0;
            for (int g = 0; g < Twv.length; g++) {
                Twvsum += Integer.parseInt(String.valueOf(Twv[g]), 12);
            }

            char[] Hex = Integer.toHexString(i).toCharArray();
            int Hexsum = 0;
            for (int k = 0; k < Hex.length; k++) {
                Hexsum += Integer.parseInt(String.valueOf(Hex[k]), 16);
            }
            if (Hexsum == Tensum && Hexsum == Twvsum && Tensum == Twvsum)
                System.out.println(i);
        }
    }

    static String change(int num, int su) {
        LinkedList stack = new LinkedList();
        String result = "";

        while (num > 0) {
            if (num % su > 9) {
                stack.add((char) (num % su + 55));
            } else {
                stack.add(num % su);
            }
            num = num / su;
        }
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        if (result.equals("")) result = "0";

        return result;
    }

}
