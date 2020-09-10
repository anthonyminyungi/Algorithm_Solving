package com.algorithms.Programmers.MonthlyCodeChallenge.Sept;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    public static int[] solution(int n) {
        int arr[][] = new int[n][n];
        int x = -1, y = -1;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    x++;
                    y++;
                } else if (i % 3 == 1) {
                    y--;
                } else {
                    x--;
                }
                arr[x][y] = num++;
            }
        }
        int size = 0;
        for (int i = 1; i <= n; i++) {
            size += i;
        }
        int[] answer = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] != 0) {
                    answer[idx] = arr[i][j];
                    idx++;
                }
            }
        }
        return answer;
    }
}
