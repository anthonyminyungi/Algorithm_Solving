package com.algorithms.Programmers.Practice.Level3;

public class Level3_SchoolRoad {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
    }


    public static int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            grid[puddle[1]][puddle[0]] = -1;
        }

        dp[1][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i][j] == -1) dp[i][j] = 0;
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
            }
        }

        return dp[n][m];
    }
}
