package com.algorithms.BOJ.JAVA;

import java.util.Scanner;

public class SugarDeliver_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int thr = 0, five = input / 5;
        input %= 5;

        while (five >= 0) {
            if (input % 3 == 0) {
                thr = input / 3;
                input %= 3;
                break;
            }
            five--;
            input += 5;
        }

        System.out.printf("%d", input == 0 ? five + thr : -1);


    }
}
