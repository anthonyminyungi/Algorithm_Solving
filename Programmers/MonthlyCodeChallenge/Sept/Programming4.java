package com.algorithms.Programmers.MonthlyCodeChallenge.Sept;


// 솔루션 참고하여 풀이함. 나중에 다시 보기.
// https://yabmoons.tistory.com/583
public class Programming4 {
    final static long MOD = 10000019;
    static long[][] combinations;

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 1, 0}, {1, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 0}, {1, 0, 0}}));
        System.out.println(solution(new int[][]{{1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        combinations = new long[301][301];
        combinations[0][0] = 1;
        for (int i = 1; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                if (j == 0) combinations[i][j] = 1;
                else if (i == j) combinations[i][j] = 1;
                else combinations[i][j] = combinations[i - 1][j - 1] + combinations[i - 1][j];

                combinations[i][j] %= MOD;
            }
        }
        int[] oneCnts = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                oneCnts[j + 1] += a[i][j];
            }
        }

        long[][] dp = new long[m + 1][n + 1];
        dp[1][n - oneCnts[1]] = combinations[n][n - oneCnts[1]];

        for (int col = 1; col <= m; col++) {
            int oneCnt = oneCnts[col];
            for (int num = 0; num <= n; num++) {
                for (int k = 0; k <= oneCnt; k++) {
                    int willSetOddRow = oneCnt - k;
                    int willBeEvenRowCnt = (num - k) + willSetOddRow;
                    if (willSetOddRow < 0 || willBeEvenRowCnt > n || willBeEvenRowCnt < 0) continue;

                    long numOfCase = (combinations[num][k] * combinations[n - num][oneCnt - k]) % MOD;
                    dp[col][willBeEvenRowCnt] += dp[col - 1][num] * numOfCase % MOD;
                    dp[col][willBeEvenRowCnt] %= MOD;
                }
            }
        }

        return (int) dp[m][n];
    }
}
