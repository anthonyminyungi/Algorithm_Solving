package com.algorithms.Programmers.MonthlyCodeChallenge2.May;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        int cnt;
        for (int i = left; i <= right; i++) {
            cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) cnt++;
            }
            answer += (cnt % 2 == 0) ? i : -i;
        }
        return answer;
    }
}
