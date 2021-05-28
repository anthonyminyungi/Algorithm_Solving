package com.algorithms.Programmers.Practice.Level4;

public class Level4_3xNTiling {
    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(6));
        System.out.println(solution(1000));
        System.out.println(solution(3000));
        System.out.println(solution(4000));
        System.out.println(solution(5000));
    }

    // 세로 길이가 3이고 사용하는 타일은 1x2 2x1 이기 때문에 가로 길이가 홀수일 때에는 구할수 없음.
    // 점화식을 구해도 숫자가 커질수록 long 으로 형변환을 해도 그 범위를 벗어날 수 있음.
    // 값의 범위를 넘어서면 그 넘어선 값만큼의 음수 값이 나오므로 MOD 값으로 나눠주는 대신 더하고,
    // 양수이면 값의 범위를 넘지 않았다는 뜻이므로 MOD 값으로 나눠준다.
    public static int solution(int n) {
        final int MOD = 1000000007;
        long[] dp = new long[n / 2 + 1];
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n / 2; i++) {
            dp[i] = (dp[i - 1] * 4 - dp[i - 2]);
            dp[i] = dp[i] > 0 ? dp[i] % MOD : dp[i] + MOD;
        }
        return (int) dp[n / 2];
    }
}
