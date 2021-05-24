package com.algorithms.Programmers.Practice.Level3;

public class Level3_Change {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 5}));
        System.out.println(solution(10, new int[]{1, 2, 5}));
        System.out.println(solution(7, new int[]{2, 3, 4}));
    }

    public static int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int k : money) {
            for (int j = k; j <= n; j++) {
                if (j >= k)
                    dp[j] += dp[j - k];
            }
        }

        return dp[n];
    }
}
