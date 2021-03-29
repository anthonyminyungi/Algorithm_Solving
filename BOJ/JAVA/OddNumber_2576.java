package com.algorithms.BOJ.JAVA;

import java.io.*;

public class OddNumber_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k % 2 != 0) {
                sum += k;
                min = Math.min(min, k);
            }

        }
        if (sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
