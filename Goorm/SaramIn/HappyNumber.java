package com.algorithms.Goorm.SaramIn;

import java.io.*;
import java.util.*;

public class HappyNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        String tempN = n;
        boolean happy = false;
        Set<Integer> looped = new HashSet<>();
        while (true) {
            int newN = 0;
            char[] chars = tempN.toCharArray();
            for (char aChar : chars) {
                newN += (aChar - '0') * (aChar - '0');
            }

            if (newN == 1) {
                happy = true;
                break;
            }
            if (looped.contains(newN)) {
                happy = false;
                break;
            } else {
                looped.add(newN);
            }

            tempN = String.valueOf(newN);
        }

        System.out.println(n + " is " + (happy ? "Happy " : "Unhappy ") + "Number.");
    }
}
