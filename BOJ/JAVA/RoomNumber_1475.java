package com.algorithms.BOJ.JAVA;

import java.io.*;

public class RoomNumber_1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] numbers = new int[11];
        for (int i = 0; i < s.length(); i++) {
            numbers[s.charAt(i) - '0']++;
        }

        int maxCnt = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (i != 6 && i != 9 && maxCnt < numbers[i])
                maxCnt = numbers[i];
        }

        int nineAndSix = numbers[6] + numbers[9];

        System.out.println(Math.max(Math.round((double) nineAndSix / 2), maxCnt));
    }
}
