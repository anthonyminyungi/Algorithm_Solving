package com.algorithms.HackerRank.CNU_NHN;

import java.io.*;

// dp 문제. 문제를 이해 못해서 시간 안에 못풀었다.
// 비슷한 문제 : https://www.acmicpc.net/problem/10422
public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 != 0) {
            System.out.println(-1);
        } else if (N == 0) {
            System.out.println(1);
        } else {
            long[] dp = new long[N / 2 + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= N / 2; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - 1 - j];
                }
            }
            System.out.println(dp[N / 2]);
        }
    }
}
