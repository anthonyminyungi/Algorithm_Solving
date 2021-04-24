package com.algorithms.SWExpert_Academy.MockTest;

import java.io.*;
import java.util.*;

public class FindDefector_1953 {
    static int N, M, R, C, L;
    static int[][] map = new int[50][50];
    static int[][] tunnelTypes = { // 상,하,좌,우
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 1, 1, 0},
            {1, 0, 1, 0},
    };
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int T = t;
        while (t-- > 0) {
            int[] vars = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = vars[0];
            M = vars[1];
            R = vars[2];
            C = vars[3];
            L = vars[4];

            for (int i = 0; i < N; i++) {
                int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = row[j];
                }
            }

            bw.append("#").append(String.valueOf(T - t)).append(" ").append(String.valueOf(solve())).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int solve() {
        Queue<Tunnel> q = new LinkedList<>();
        boolean[][] visited = new boolean[50][50];
        int cnt = 0;

        Tunnel start = new Tunnel(R, C, map[R][C] - 1);
        visited[R][C] = true;
        q.add(start);


        while (L-- > 1) {
            int currSize = q.size();
            while (currSize-- > 0) {
                Tunnel cur = q.poll();
                int[] type = tunnelTypes[cur.t];

                for (int i = 0; i < 4; i++) {
                    if (type[i] == 1) {
                        int nr = cur.r + dr[i], nc = cur.c + dc[i];
                        if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) continue;
                        if (map[nr][nc] == 0) continue;
                        if (visited[nr][nc]) continue;
                        int target = map[nr][nc] - 1;
                        if (i == 0) {
                            if (tunnelTypes[target][1] == 0) continue;
                        } else if (i == 1) {
                            if (tunnelTypes[target][0] == 0) continue;
                        } else if (i == 2) {
                            if (tunnelTypes[target][3] == 0) continue;
                        } else {
                            if (tunnelTypes[target][2] == 0) continue;
                        }

                        visited[nr][nc] = true;
                        q.add(new Tunnel(nr, nc, map[nr][nc] - 1));
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Tunnel {
        int r, c, t;

        Tunnel(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}
