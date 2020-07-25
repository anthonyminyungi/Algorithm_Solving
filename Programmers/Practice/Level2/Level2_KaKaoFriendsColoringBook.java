package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Level2_KaKaoFriendsColoringBook {
    //    [[1, 1, 1, 0],
//     [1, 2, 2, 0],
//     [1, 0, 0, 1],
//     [0, 0, 0, 1],
//     [0, 0, 0, 3],
//     [0, 0, 0, 3]]
    static boolean[][] visited;
    static int numberOfArea;
    static List<Integer> sizes;
    static int currentSize;

    public static void main(String... args) {
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
        System.out.println(Arrays.toString(solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}})));

    }

    public static int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        visited = new boolean[m][n];
        sizes = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                currentSize = 0;
                if (!visited[i][j] && picture[i][j] != 0) {
                    dfs(picture, i, j, picture[i][j]);
                    numberOfArea++;
                    sizes.add(currentSize);
                }
            }
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }
        Collections.sort(sizes);
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = sizes.get(sizes.size() - 1);
        return answer;
    }

    public static void dfs(int[][] picture, int x, int y, int find) {
        visited[x][y] = true;
        currentSize++;
        int[][] points = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int k = 0; k < points.length; k++) {
            int dx = x + points[k][0];
            int dy = y + points[k][1];
            if (dx >= 0 && dx < picture.length && dy >= 0 && dy < picture[0].length && !visited[dx][dy] && picture[dx][dy] == find) {
                dfs(picture, dx, dy, find);
            }
        }
    }
}
