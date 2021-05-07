package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FindingPath_11403 {
    static int[][] map;
    static int[][] map2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        map2 = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                map2[i][j] = map[i][j];
            }
        }

        bfs(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map2[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int n) {
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    q.add(j);
                    visited[j] = true;
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                map2[i][cur] = 1;

                for (int j = 0; j < n; j++) {
                    if (map[cur][j] == 1) {
                        if (visited[j]) continue;

                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
        }
    }
}
