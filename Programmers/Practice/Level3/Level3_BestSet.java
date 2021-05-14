package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 개어거지로품. 문제가 이상한듯.
public class Level3_BestSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
        System.out.println(Arrays.toString(solution(2, 8)));
        double before = System.currentTimeMillis();
        solution(3, 8);
        double after = System.currentTimeMillis();
        System.out.println((after - before) + "ms");
        System.out.println(Arrays.toString(solution(3, 9)));
        System.out.println(Arrays.toString(solution(3, 16)));
        System.out.println(Arrays.toString(solution(2, 15)));
        System.out.println(Arrays.toString(solution(10, 16)));
        System.out.println(Arrays.toString(solution(10, 15)));
        before = System.currentTimeMillis();
        solution(9876, 98765432);
        after = System.currentTimeMillis();
        System.out.println((after - before) + "ms");
    }

    public static int[] solution(int n, int s) {
        if (s / n == 0) return new int[]{-1};
        int[] answer = new int[n];
        if (s % n == 0) {
            Arrays.fill(answer, s / n);
        } else {
            int idx = 0, std, div;
            double div2, half = 0.5;
            while (n > 0 && s > 0) {
                div = s / n;
                div2 = s / n;
                std = (div2 - div) < half ? div : div + 1;
                answer[idx++] = std;
                s -= std;
                n--;
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}
