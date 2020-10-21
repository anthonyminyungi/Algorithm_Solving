package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// dp
public class FirstGrade_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] dp = new long[n][21];

        dp[0][in[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] >= 0) {
                    if (j - in[i] >= 0)
                        dp[i][j - in[i]] += dp[i - 1][j];
                    if (j + in[i] <= 20)
                        dp[i][j + in[i]] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 2][in[n - 1]]);
    }
}
