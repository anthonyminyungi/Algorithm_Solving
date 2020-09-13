package com.algorithms.BOJ.JAVA;

import java.io.*;

public class AscendStair_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = f[1];
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = f[1] + f[2];
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }
        dp[3] = Math.max(f[1] + f[3], f[2] + f[3]);
        if (n == 3) {
            System.out.println(dp[3]);
            return;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + f[i] + f[i - 1], dp[i - 2] + f[i]);
        }
        System.out.println(dp[n]);
    }
}
