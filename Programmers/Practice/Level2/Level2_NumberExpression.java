package com.algorithms.Programmers.Practice.Level2;

public class Level2_NumberExpression {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(9));
        System.out.println(solution(8));
        System.out.println(solution(1800));
        System.out.println(solution(15));
        System.out.println(solution(10000));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (correct(i, n))
                answer++;
        }
        return answer;
    }

    public static boolean correct(int k, int n) {
        int sum = 0;
        for (int i = k; i <= n; i++) {
            sum += i;
            if (sum >= n)
                break;
        }
        return sum == n;
    }
}
