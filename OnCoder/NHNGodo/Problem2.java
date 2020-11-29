package com.algorithms.OnCoder.NHNGodo;

import java.util.*;
import java.util.stream.*;

// BOJ 1107 동일 문제
public class Problem2 {
    static List<Integer> brokenList;

    public static void main(String[] args) {
        System.out.println(solution(5457, new int[]{6, 7, 8}));
        System.out.println(solution(100, new int[]{1, 0, 5}));
        System.out.println(solution(99999, new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(solution(158, new int[]{1, 9, 2, 5, 4}));
        System.out.println(solution(151241, new int[]{0, 1, 2, 3, 4, 7, 8, 9}));
    }

    public static int solution(int page, int[] broken) {
        if (page == 100) return 0;
        brokenList = Arrays.stream(broken).boxed().collect(Collectors.toList());
        int min = Math.abs(page - 100);
        for (int i = 0; i <= 1000000; i++) {
            int length = check(i);

            if (length > 0) min = Math.min(min, Math.abs(page - i) + length);
        }

        return min;
    }

    private static int check(int n) {
        int length = 0;
        if (n == 0) return brokenList.contains(n) ? 0 : 1;

        while (n > 0) {
            if (brokenList.contains(n % 10)) return 0;
            length++;
            n /= 10;
        }
        return length;
    }
}
