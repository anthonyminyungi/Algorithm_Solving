package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Tiling2xn2_11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println(1);
        else {
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 3;

            for (int i = 3; i <= n; i++) {
                dp[i] = (2 * dp[i - 1] + (i % 2 == 0 ? 1 : -1)) % 10007;
            }
            System.out.println(dp[n]);
        }
    }
}
