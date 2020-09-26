package com.algorithms.Programmers.MonthlyCodeChallenge.Sept;

// 20점
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, -1, -5}));
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    public static int solution(int[] a) {
        int answer = 2;
        int l = a[0], r = a[a.length - 1];
        for (int i = 1; i < a.length - 1; i++) {
            if (l > a[i]) {
                l = a[i];
                answer++;
            }
            if (r > a[a.length - 1 - i]) {
                r = a[a.length - 1 - i];
                answer++;
            }
        }
        return l == r ? answer - 1 : answer;
    }
}
