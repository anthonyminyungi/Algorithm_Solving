package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Thirty_10610 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = br.readLine().toCharArray();
        int digitSum = 0;
        boolean containsZero = false;
        for (char number : numbers) {
            if (number == '0') containsZero = true;
            digitSum += (number - '0');
        }
        if (!containsZero || digitSum % 3 != 0) System.out.println(-1);
        else {
            Arrays.sort(numbers);
            String sorted = new StringBuilder(String.valueOf(numbers)).reverse().toString();
            System.out.println(sorted);
        }
    }
}
