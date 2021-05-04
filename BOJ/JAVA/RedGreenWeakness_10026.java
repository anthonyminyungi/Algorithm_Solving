package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class RedGreenWeakness_10026 {
    static char[][] paint;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int normal, weak;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paint = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            paint[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(paint[i][j], i, j, false);
                    normal++;
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(paint[i][j], i, j, true);
                    weak++;
                }
            }
        }

        System.out.println(normal + " " + weak);
    }

    static void bfs(char c, int x, int y, boolean isWeak) {
        Queue<Color> q = new LinkedList<>();
        q.offer(new Color(c, x, y));
        visited[x][y] = true;
        int n = paint.length;

        while (!q.isEmpty()) {
            Color cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + d[i][0], ny = cur.y + d[i][1];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) continue;
                if (visited[nx][ny]) continue;
                if (isWeak) {
                    if (cur.c == 'R' || cur.c == 'G') {
                        if (paint[nx][ny] == 'B') continue;
                    } else {
                        if (cur.c != paint[nx][ny]) continue;
                    }
                } else {
                    if (cur.c != paint[nx][ny]) continue;
                }

                q.add(new Color(c, nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Color {
        int x, y;
        char c;

        Color(char c, int x, int y) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
