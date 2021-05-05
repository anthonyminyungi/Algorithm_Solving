package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 모든 전파 가능 지점에서 동시에 진행되어 완료하기까지의 시점을 구하는 경우 Queue에 미리 해당 전파 가능 지점을 넣어두고
// 완료 시점까지를 bfs로 동시에 탐색하는 방법을 취해야 한다.
// 수행시간 : 1060ms (조건 1초에 약간 아슬아슬함)

public class Tomato_7579 {
    static int[][][] tomatos;
    static boolean[][][] visited;
    static int[][] d = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static int m, n, h, zeroCnt;
    static Queue<Tomato> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mnh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = mnh[0];
        n = mnh[1];
        h = mnh[2];
        tomatos = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tomatos[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }
        q = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatos[i][j][k] == 1)
                        q.add(new Tomato(i, j, k));
                    else if (tomatos[i][j][k] == 0) zeroCnt++;

                }
            }
        }
        if (zeroCnt == 0) {
            System.out.println(0);
            return;
        }

        int qs = q.size();
        boolean isCompleted;
        int cnt = 0;

        while (!q.isEmpty()) {
            cnt++;
            isCompleted = bfs(qs);
            qs = q.size();

            if (isCompleted) {
                System.out.println(cnt);
                return;
            }
        }

        System.out.println(-1);
    }

    static boolean bfs(int size) {
        while (!q.isEmpty() && size-- > 0) {
            Tomato cur = q.poll();

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + d[i][0], nx = cur.x + d[i][1], ny = cur.y + d[i][2];

                if (nz < 0 || nz > h - 1 || nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                if (visited[nz][nx][ny] || tomatos[nz][nx][ny] != 0) continue;
                visited[nz][nx][ny] = true;
                if (tomatos[nz][nx][ny] == 1) continue;
                q.add(new Tomato(nz, nx, ny));
                tomatos[nz][nx][ny] = 1;
                zeroCnt--;
                if (zeroCnt == 0) return true;
            }
        }

        return false;
    }

    static class Tomato {
        int x, y, z;

        Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}
