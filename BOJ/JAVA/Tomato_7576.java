package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// BFS
public class Tomato_7576 {
    static int[][] tomatoes;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int m = Integer.parseInt(nm[0]);
        int n = Integer.parseInt(nm[1]);

        tomatoes = new int[n][m];


        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(line[j]);
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                if (tomatoes[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] location = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int[] newDir = directions[dir];
                int newX = location[0] + newDir[0];
                int newY = location[1] + newDir[1];

                if (newX < 0 || newY < 0 || newX >= tomatoes.length || newY >= tomatoes[0].length) continue;
                if (tomatoes[newX][newY] != 0) continue;

                tomatoes[newX][newY] += tomatoes[location[0]][location[1]] + 1;
                q.offer(new int[]{newX, newY});
            }
        }

        int max = 0;
        for (int[] tomato : tomatoes) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                if (tomato[j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, tomato[j]);
            }
        }
        System.out.println(max - 1);
    }
}
