package com.algorithms.Programmers.Practice.Level2;


// 성능 구림. 최적화 필요할 듯.

public class Level2_DigitGame {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder fullString = new StringBuilder();
        for (int i = 0; i < t * 2; i++) {
            fullString.append(Integer.toString(i, n));
        }
        System.out.println(fullString.toString());
        int seq = 1;
        for (int i = 0; i < fullString.toString().length(); i++) {
            if (p == seq) {
                answer.append(String.valueOf(fullString.toString().charAt(i)).toUpperCase());
            }
            seq++;
            if (seq > m) {
                seq = 1;
            }
            if (answer.toString().length() >= t)
                break;
        }
        return answer.toString();
    }
}
