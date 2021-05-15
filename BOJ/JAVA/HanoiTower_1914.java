package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.math.*;

public class HanoiTower_1914 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if (n <= 62) sb.append((long) Math.pow(2, n) - 1).append("\n");
        else {
            BigInteger bi = new BigInteger(String.valueOf((long) Math.pow(2, 62)));
            BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
            for (int i = 0; i < n - 62; i++) {
                bi = bi.multiply(two);
            }
            sb.append(bi.subtract(BigInteger.ONE)).append("\n");
        }
        if (n <= 20) {
            hanoi(n, 1, 2, 3);
        }

        System.out.println(sb.toString().trim());
    }

    static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(n - 1, from, to, temp);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(n - 1, temp, from, to);
        }
    }
}
