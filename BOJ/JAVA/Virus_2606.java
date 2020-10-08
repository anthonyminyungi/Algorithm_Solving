package com.algorithms.BOJ.JAVA;

import java.io.*;

// DFS
public class Virus_2606 {
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            String[] in = br.readLine().split(" ");
            int v1 = Integer.parseInt(in[0]);
            int v2 = Integer.parseInt(in[1]);

            graph[v1][v2] = graph[v2][v1] = 1;
        }
        dfs(1, N);
        bw.append(String.valueOf(cnt - 1));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int N) {
        visited[start] = true;
        cnt++;
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i, N);
            }
        }
    }
}
