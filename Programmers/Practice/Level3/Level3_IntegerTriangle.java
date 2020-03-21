package com.java.Programmers.Practice.Level3;

import java.util.Arrays;

public class Level3_IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (i == 0)
                    break;
                if (j == 0)
                    triangle[i][j] += triangle[i - 1][j];
                else if (j == triangle[i].length - 1)
                    triangle[i][j] += triangle[i - 1][j - 1];
                else
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        Arrays.sort(triangle[n - 1]);
        answer = triangle[n - 1][n - 1];
        return answer;
    }
}
