package com.algorithms.Programmers.Practice.Level3;

public class Level3_Jumping {
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(2000));
    }

    public static long solution(int n) {
        long answer;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
            }
        }
        answer = dp[n];
        return answer;
    }
}
