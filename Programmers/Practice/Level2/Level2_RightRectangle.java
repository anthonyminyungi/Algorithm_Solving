package com.java.Programmers.Practice.Level2;


// 무슨 공식문제네... 알면 바로 풀고 모르면 오래걸리는 문제
public class Level2_RightRectangle {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
        System.out.println(solution(8, 11));
        System.out.println(solution(7, 12));
    }

    public static long solution(int w, int h) {
        long answer = 1;
        long lw = w;
        long lh = h;
        long gcd = 0;
        long small = Math.min(lw, lh);
        for (long i = small; i >= 1; i--) {
            if (lw % i == 0 && lh % i == 0) {
                gcd = i;
                break;
            }
        }
        answer = lw * lh - (lw + lh - gcd);
        return answer;
    }
}
