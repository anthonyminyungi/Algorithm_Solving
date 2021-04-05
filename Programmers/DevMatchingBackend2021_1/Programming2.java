package com.algorithms.Programmers.DevMatchingBackend2021_1;

import java.util.*;

public class Programming2 {
    static final int INF = 987654321;

    public static void main(String[] args) {
        //6	6	[[2,2,5,4],[3,3,6,6],[5,1,6,3]]	[8, 10, 25]
        //3	3	[[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
        //100	97	[[1,1,100,97]]	[1]
        System.out.println(Arrays.toString(solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = val++;
            }
//            System.out.println(Arrays.toString(map[i]));
        }
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1, y1 = query[1] - 1, x2 = query[2] - 1, y2 = query[3] - 1;
            int min = INF;
            int temp = map[x1][y1];
            for (int r = x1; r <= x2 - 1; r++) {
                map[r][y1] = map[r + 1][y1];
                min = Math.min(min, map[r][y1]);
            }

            for (int c = y1; c <= y2 - 1; c++) {
                map[x2][c] = map[x2][c + 1];
                min = Math.min(min, map[x2][c]);
            }

            for (int r = x2; r >= x1 + 1; r--) {
                map[r][y2] = map[r - 1][y2];
                min = Math.min(min, map[r][y2]);
            }

            for (int c = y2; c > y1 + 1; c--) {
                map[x1][c] = map[x1][c - 1];
                min = Math.min(min, map[x1][c]);
            }
            map[x1][y1 + 1] = temp;
            min = Math.min(min, temp);

            answer[idx] = min;
            idx++;
        }

        return answer;
    }
}
