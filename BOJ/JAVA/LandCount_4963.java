package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class LandCount_4963 {
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] map;
        boolean[][] visited;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int landCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(h, w, i, j, map, visited);
                        landCnt++;
                    }
                }
            }

            bw.append(String.valueOf(landCnt)).append("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int h, int w, int r, int c, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = cur[0] + d[i][0], nc = cur[1] + d[i][1];
                if (nr < 0 || nr > h - 1 || nc < 0 || nc > w - 1) continue;
                if (map[nr][nc] == 0) continue;
                if (visited[nr][nc]) continue;

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
