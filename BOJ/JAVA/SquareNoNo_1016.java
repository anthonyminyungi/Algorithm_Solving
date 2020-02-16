package com.java.BOJ.JAVA;

import java.util.Arrays;
import java.util.Scanner;

public class SquareNoNo_1016 {
    static long min;
    static long max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        min = sc.nextLong();
        max = sc.nextLong();
        checkNoSquareNumberCount();
    }

    private static void checkNoSquareNumberCount() {
        int end = ((int) Math.sqrt(max));
        boolean[] checkArray = new boolean[1000001];
        Arrays.fill(checkArray, false);
        for (long i = 2; i <= end; i++) {
            long square = i * i;
            long start = ((min - 1) / square + 1) * square;
            for (long a = start; a <= max; a += square) {
                checkArray[(int) (a - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < (max - min + 1); i++) {
            count += (checkArray[i] == true) ? 1 : 0;
        }
        System.out.print(max - min - count + 1);
    }
}
