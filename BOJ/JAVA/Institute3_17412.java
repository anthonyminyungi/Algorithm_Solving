package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Institute3_17412 {
    static final int INF = 987654321;
    static int N, M;
    static int[][] arr = new int[50][50];
    static Point[] viruses = new Point[10];
    static int virusCnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = in[0];
        M = in[1];
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(a[j]);
                if (arr[i][j] == 2) viruses[virusCnt++] = new Point(i, j, 0);
            }
        }

        System.out.println(solve());
    }

    static int solve() {
        int ret = INF;
        for (int subset = 0; subset < 1 << virusCnt; subset++) {
            if (countBits(subset) == M) {
                boolean[][] visited = new boolean[50][50];
                int dist = 0;
                Queue<Point> q = new LinkedList<>();
                for (int i = 0; i < virusCnt; i++) {
                    if ((subset & 1 << i) != 0) {
                        visited[viruses[i].r][viruses[i].c] = true;
                        q.add(viruses[i]);
                    }
                }

                while (!q.isEmpty()) {
                    Point curr = q.poll();
                    if (arr[curr.r][curr.c] != 2)
                        dist = Math.max(dist, curr.d);

                    for (int i = 0; i < 4; i++) {
                        int nr = curr.r + dr[i];
                        int nc = curr.c + dc[i];
                        if (nr < 0 || nc < 0 || nr > N - 1 || nc > N - 1) continue;
                        if (visited[nr][nc] || arr[nr][nc] == 1) continue;
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, curr.d + 1));
                    }
                }
                boolean flag = true;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 0 && !visited[i][j]) {
                            flag = false;
                        }
                    }
                }

                if (flag) ret = Math.min(ret, dist);
            }
        }
        if (ret == INF) return -1;
        return ret;
    }

    static int countBits(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1) cnt++;
            n = n >> 1;
        }
        return cnt;
    }

    static class Point {
        int r, c, d;

        Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
