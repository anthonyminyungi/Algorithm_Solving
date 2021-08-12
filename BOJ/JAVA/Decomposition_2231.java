package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Decomposition_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        int n = Integer.parseInt(in);

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = i;
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                sum += (temp.charAt(j) - '0');
            }
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
