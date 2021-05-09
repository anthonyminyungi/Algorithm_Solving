package com.algorithms.Programmers.Practice.Level3;

// DP 문제. 두 배열로 나누어 풀 아이디어는 떠올렸으나 방식이 잘못됐었음.
public class Level3_GatheringSticker {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}));
    }

    public static int solution(int[] sticker) {
        int n = sticker.length;
        if (n == 1) return sticker[0];
        int[][] dp = new int[2][n];
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
        for (int i = 2; i < n; i++) {
            if (i < n - 1) dp[0][i] = Math.max(dp[0][i - 2] + sticker[i], dp[0][i - 1]);
            else dp[0][i] = dp[0][i - 1];
            dp[1][i] = Math.max(dp[1][i - 2] + sticker[i], dp[1][i - 1]);
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
