package com.algorithms.Programmers.Practice.Level3;

public class Level3_2xnTiling {
    public static void main(String[] args) {
        System.out.println(solution(1000));
    }

    public static int solution(int n) {
        long[] dp = new long[60001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }
}
