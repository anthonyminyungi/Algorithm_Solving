package com.java.Programmers.NaverHackday2020;

public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(3, 8, 4));
        System.out.println(solution(10, 6, 5));
        System.out.println(solution(2, 10, 4));
        System.out.println(solution(50, 150, 20));
    }

    // n 슬로프 개수, m 스키장 총 길이, k 슬로프 최대 길이
    // 슬로프는 번갈아서
    // 각 슬로프 길이의 총 합은 m / 2
    // 문제 못보니까 못풀겠다 아 모르겠다 포기

    public static int solution(int n, int m, int k) {
        if (n > m)
            return 0;
        if (n * k < m)
            return 0;
        long answer = 0;
        for (int i = 1; i <= k; i++) {
            answer += rec(1, n, m, k, i, 0, false);
        }

        answer *= 2;
        return (int) (answer % 1000000007);
    }

    public static long rec(int cn, int n, int m, int k, int s, int b, boolean isB) {
        if (s == m / 2 && b == m / 2 && cn == n) {
            return 1;
        }
        if (cn > n)
            return 0;
        long sum = 0;
        for (int i = 1; i <= k; i++) {
            if (isB)
                sum += rec(cn + 1, n, m, k, s + i, b, false);
            else
                sum += rec(cn + 1, n, m, k, s, b + i, true);
        }
        return sum;

    }
}
