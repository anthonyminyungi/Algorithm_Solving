package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start5_2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (Math.abs(N - i - 1) <= j && Math.abs(N + i - 1) >= j)
                    System.out.print("*");
                else {
                    if (Math.abs(N - i - 1) > j)
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
