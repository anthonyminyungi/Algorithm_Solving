package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class DFSandBFS_1260 {
    static int[][] graph;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int V = Integer.parseInt(in[2]);

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int v1 = Integer.parseInt(in[0]);
            int v2 = Integer.parseInt(in[1]);
            graph[v1][v2] = graph[v2][v1] = 1;
        }
        dfs(V, N);
        bw.append("\n");
        visited = new boolean[N + 1];
        bfs(V, N);
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int N) throws IOException {
        visited[start] = true;
        bw.append(String.valueOf(start)).append(" ");
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i, N);
            }
        }
    }

    static void bfs(int start, int N) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            bw.append(String.valueOf(temp)).append(" ");

            for (int j = 1; j <= N; j++) {
                if (graph[temp][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
