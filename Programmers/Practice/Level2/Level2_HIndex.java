package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;

public class Level2_HIndex {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(solution(new int[]{20, 19, 18, 1}));
        System.out.println(solution(new int[]{22, 42}));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int n = citations.length;
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Math.min(citations[i], citations.length - i);
        }
        Arrays.sort(h);
        answer = h[n - 1];
        return answer;
    }
}
