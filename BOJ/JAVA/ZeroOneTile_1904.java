package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ZeroOneTile_1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n];
        dp[0] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 2;
        if (n == 2) {
            System.out.println(2);
            return;
        }
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[n - 1]);
    }
}
