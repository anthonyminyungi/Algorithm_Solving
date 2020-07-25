package com.algorithms.Programmers.Practice;

import java.util.Arrays;

public class OptimizedMatrixMultiplication {
    public static void main(String[] args) {
        int[][] to = {{5, 3}, {3, 10}, {10, 6}};
        System.out.println(solution(to));
    }

    public static int solution(int[][] matrix_sizes) {
        int answer = 0;
        int[] p = new int[matrix_sizes.length + 1];
        p[0] = matrix_sizes[0][0];
        p[1] = matrix_sizes[0][1];

        for (int i = 2; i < p.length; i++) {
            p[i] = matrix_sizes[i - 1][1];
        }
        System.out.println(Arrays.toString(p));
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        int j;
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        answer = m[1][n];
        return answer;
    }
}
