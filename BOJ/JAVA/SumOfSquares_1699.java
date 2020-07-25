package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSquares_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[(int) Math.sqrt(n)];
        int[] dp = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * (i + 1);
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int value : arr) {
            for (int j = value; j <= n; j++) {
                dp[j] = Math.min(dp[j - value] + 1, dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
