package com.algorithms.Codility.Naver_20201015;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 1, 6, 5, 9, 7}));
        System.out.println(solution(new int[]{4, 3, 2, 6, 1}));
        System.out.println(solution(new int[]{2, 1, 6, 4, 3, 7}));
    }

    public static int solution(int[] A) {
        if (A.length < 2) return A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) stack.push(i);
            for (int j = i; j > 0 && A[j] < A[j - 1]; j--) {
                swap(A, j, j - 1);
                if (!stack.isEmpty() && j <= stack.peek()) stack.pop();
            }
        }
        return stack.size();
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
