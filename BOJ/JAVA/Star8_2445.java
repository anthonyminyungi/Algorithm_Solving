package com.java.BOJ.JAVA;

import java.io.*;

public class Star8_2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 2 * N - 1; i++) {
            for (int j = 1; j <= 2 * N; j++) {
                if (j <= i && 2 * N - i < j) {
                    System.out.print(" ");
                } else if (j > i && 2 * N - i >= j) {
                    System.out.print(" ");
                } else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
