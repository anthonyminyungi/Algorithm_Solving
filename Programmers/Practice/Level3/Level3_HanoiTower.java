package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_HanoiTower {
    static int i;
    static int[][] answer;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(15)));
    }

    public static int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        i = 0;
        hanoi(n, 1, 2, 3);
        return answer;
    }

    static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            answer[i] = new int[]{from, to};
            i++;
        } else {
            hanoi(n - 1, from, to, temp);
            hanoi(1, from, temp, to);
            hanoi(n - 1, temp, from, to);
        }
    }
}

