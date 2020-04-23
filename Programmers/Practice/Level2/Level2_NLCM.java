package com.java.Programmers.Practice.Level2;

import java.util.Arrays;

public class Level2_NLCM {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14}));
        System.out.println(solution(new int[]{1, 2, 3}));
    }

    public static int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int standard = arr[arr.length - 1];
        int mul = 1;
        boolean check;
        int comp;
        while (true) {
            check = true;
            comp = standard * mul;
            for (int i = 0; i < arr.length - 1; i++) {
                if (comp % arr[i] != 0) {
                    check = false;
                    break;
                }
            }
            mul += 1;
            if (check) {
                break;
            }
        }
        answer = comp;
        return answer;
    }
}
