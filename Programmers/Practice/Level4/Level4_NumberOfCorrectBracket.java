package com.algorithms.Programmers.Practice.Level4;

// dp
// 카탈린 수
public class Level4_NumberOfCorrectBracket {
    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
