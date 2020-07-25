package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;

public class Level2_MatrixMultiply {
    public static void main(String[] args) {
        int[][] arr1_1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2_1 = {{3, 3}, {3, 3}};
        System.out.println(Arrays.deepToString(solution(arr1_1, arr2_1)));
        int[][] arr1_2 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2_2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        System.out.println(Arrays.deepToString(solution(arr1_2, arr2_2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        int n = arr1.length;
        int m = arr2.length;
        int k = arr2[0].length;
        answer = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int l = 0; l < m; l++) {
                    sum += arr1[i][l] * arr2[l][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
