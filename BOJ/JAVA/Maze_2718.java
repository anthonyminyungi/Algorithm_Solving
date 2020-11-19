package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Maze_2718 {

    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int[][] maze;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        maze = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line[j] - '0';
            }
        }

        bfs(0, 0);

        System.out.println(maze[n - 1][m - 1]);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();
            visited[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int[] newDir = dir[d];
                int i = location[0] + newDir[0];
                int j = location[1] + newDir[1];

                if ((i >= 0 && i < n && j >= 0 && j < m) && maze[i][j] != 0 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    maze[i][j] = maze[location[0]][location[1]] + 1;
                }
            }
        }
    }
}
