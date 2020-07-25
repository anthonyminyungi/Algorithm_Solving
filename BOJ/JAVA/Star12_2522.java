package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star12_2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < N; j++) {

                if (i == N - 1)
                    System.out.print("*");
                else {
                    if (j >= Math.abs(N - 1 - i)) {
                        System.out.print("*");
                    } else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
