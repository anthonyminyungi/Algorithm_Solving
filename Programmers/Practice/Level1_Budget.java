package com.java.Programmers.Practice;

import java.util.Arrays;

public class Level1_Budget {
    public static void main(String[] args) {
        int[] d1 = {1, 3, 2, 5, 4};
        int[] d2 = {2, 2, 3, 3};
        int b1 = 9;
        int b2 = 10;
        System.out.println(solution(d1, b1));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int temp = 0;
        for (int i = 0; i < d.length; i++) {
            if (temp + d[i] <= budget) {
                temp += d[i];
                answer++;
            }
        }
        return answer;
    }
}
