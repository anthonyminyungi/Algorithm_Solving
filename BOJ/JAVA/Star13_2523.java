package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Star13_2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 2 * n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= n) {
                    if (Math.abs(j - i) < n) System.out.print("*");
                } else {
                    if (j <= i) System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
