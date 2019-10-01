package com.java.BOJ.JAVA;

import java.io.*;

public class Dice_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");

        int first = Integer.parseInt(a[0]);
        int second = Integer.parseInt(a[1]);
        int third = Integer.parseInt(a[2]);

        int result = 0;
        if (first == second && second == third) {
            result += 10000 + first * 1000;
        } else if (first == second && second != third) {
            result += 1000 + first * 100;
        } else if (second == third && first != second) {
            result += 1000 + second * 100;
        } else if (first == third && second != third) {
            result += 1000 + third * 100;
        } else if (first != second && second != third) {
            int max = Math.max(first, second);
            max = Math.max(max, third);
            result += max * 100;
        }
        bw.append(result + "");
        bw.flush();
        bw.close();
        br.close();


    }
}
