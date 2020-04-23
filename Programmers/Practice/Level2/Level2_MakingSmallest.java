package com.java.Programmers.Practice.Level2;

import java.util.Arrays;

public class Level2_MakingSmallest {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        System.out.println(solution(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int bindex = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[bindex];
            bindex -= 1;
        }
        return answer;
    }
}
