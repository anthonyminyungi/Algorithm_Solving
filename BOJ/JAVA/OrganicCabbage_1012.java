package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class OrganicCabbage_1012 {
    static int n, m;
    static int[][] map;
    static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int[] nmk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nmk[0];
            m = nmk[1];
            int k = nmk[2];
            map = new int[n][m];
            for (int i = 0; i < k; i++) {
                int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map[xy[0]][xy[1]] = 1;
            }

            bw.append(String.valueOf(bfs())).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs() {
        int res = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int l = 0; l < 4; l++) {
                            int nx = cur[0] + d[l][0], ny = cur[1] + d[l][1];

                            if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                            if (visited[nx][ny] || map[nx][ny] == 0) continue;

                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }

                    res += 1;
                }
            }
        }

        return res;
    }
}
