package com.algorithms.Programmers.SkillCheck.Level3;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx = 0, bIdx = 0;
        while (aIdx < len && bIdx < len) {
            if (A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
                bIdx++;
            } else {
                bIdx++;
            }
        }

        return answer;
    }
}
