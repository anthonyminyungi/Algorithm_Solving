package com.algorithms.Programmers.Practice.Level3;

public class Leve3_WalkerHeaven {
    static int MOD = 20170805;

    public static void main(String[] args) {
        System.out.println(solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }

    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m + 1][n + 1]; // 0 : Left, 1 : Up
        dp[0][1][0] = dp[1][0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - 1 > 0 && j - 1 > 0) {
                    dp[0][i][j] = (cityMap[i - 1][j - 2] == 2) ? dp[0][i][j - 1] % MOD : (dp[0][i][j - 1] + dp[1][i][j - 1]) % MOD;
                    dp[1][i][j] = (cityMap[i - 2][j - 1] == 2) ? dp[1][i - 1][j] % MOD : (dp[1][i - 1][j] + dp[0][i - 1][j]) % MOD;
                } else { // i = 1 혹은 j = 1 일때, 값 -> 1
                    if (i == 1) dp[0][i][j] = dp[0][i][j - 1] + dp[0][i - 1][j];
                    if (j == 1) dp[1][i][j] = dp[1][i][j - 1] + dp[1][i - 1][j];
                }

                if (cityMap[i - 1][j - 1] == 1)
                    dp[0][i][j] = dp[1][i][j] = 0;
            }
        }

        return (dp[0][m][n] + dp[1][m][n]) % MOD;
    }
}
