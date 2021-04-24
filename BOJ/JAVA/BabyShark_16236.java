package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class BabyShark_16236 {
    static final int INF = 987654321;
    static int N;
    static int[][] Map = new int[20][20];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int sr = 0, sc = 0;
        for (int i = 0; i < N; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                Map[i][j] = in[j];
                if (Map[i][j] == 9) {
                    sr = i;
                    sc = j;
                    Map[i][j] = 0;
                }
            }
        }

        System.out.println(solve(sr, sc));
    }

    static int solve(int r, int c) {
        int ret = 0;
        int size = 2, cnt = 2;

        Point minPt = new Point(r, c, 0);

        while (minPt.d != INF) {
            boolean[][] visited = new boolean[20][20];
            Queue<Point> q = new LinkedList<>();
            visited[minPt.r][minPt.c] = true;
            q.add(new Point(minPt.r, minPt.c, 0));
            minPt.d = INF;

            while (!q.isEmpty()) {
                Point cur = q.poll();

                if (cur.d > minPt.d) break;
                if (Map[cur.r][cur.c] > size) continue;
                if (Map[cur.r][cur.c] != 0 && Map[cur.r][cur.c] < size) {
                    if (cur.d < minPt.d)
                        minPt = cur;
                    else if (cur.d == minPt.d) {
                        if (cur.r < minPt.r)
                            minPt = cur;
                        else if (cur.r == minPt.r && cur.c < minPt.c)
                            minPt = cur;
                    }
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i], nc = cur.c + dc[i];
                    if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) continue;
                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, cur.d + 1));
                }
            }

            if (minPt.d != INF) {
                ret += minPt.d;
                --cnt;
                if (cnt == 0) {
                    size++;
                    cnt = size;
                }
                Map[minPt.r][minPt.c] = 0;
            }
        }

        return ret;
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
