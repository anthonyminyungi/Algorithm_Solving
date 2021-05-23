package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class MoveBreakingWall_2206 {
    static int[][] map;
    static int[][] D = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j] - '0';
            }
        }

        System.out.println(bfs(n, m));
    }

    static int bfs(int n, int m) {
        int res = 987654321;
        Queue<Path> q = new LinkedList<>();
        boolean[][][] visited = new boolean[2][n][m]; // 방문 배열을 벽을 부순경우, 부수지 않은 경우로 나누어서 진행해야함.
        visited[0][0][0] = true;
        q.add(new Path(0, 0, 1, false));

        while (!q.isEmpty()) {
            Path cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                res = Math.min(res, cur.d);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + D[i][0], ny = cur.y + D[i][1];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                if (cur.breakWall && map[nx][ny] == 1) continue;

                if (!cur.breakWall) {
                    if (visited[0][nx][ny]) continue;
                    if (map[nx][ny] == 1) {
                        q.add(new Path(nx, ny, cur.d + 1, true));
                        visited[1][nx][ny] = true;
                    } else {
                        q.add(new Path(nx, ny, cur.d + 1, false));
                        visited[0][nx][ny] = true;
                    }

                } else {
                    if (visited[1][nx][ny]) continue;
                    if (map[nx][ny] == 0)
                        q.add(new Path(nx, ny, cur.d + 1, true));
                    visited[1][nx][ny] = true;
                }
            }
        }

        return res == 987654321 ? -1 : res;
    }

    static class Path {
        int x, y, d;
        boolean breakWall;

        Path(int x, int y, int d, boolean w) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.breakWall = w;
        }
    }
}
