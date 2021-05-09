package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 두 배열 모두 정렬 후 크기 비교에 따라 양쪽 혹은 한쪽만 인덱스를 증가시키는 방식.
public class Level3_NumberGame {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8})); // 1 3 5 7
        System.out.println(solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int aIdx = 0, bIdx = 0;

        while (bIdx < n) {
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
