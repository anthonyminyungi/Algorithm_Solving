package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ConnectedComponent_11724 {
    static int[][] graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int[] uv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[uv[0]][uv[1]] = graph[uv[1]][uv[0]] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, n);
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int v, int n) {
        visited[v] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i, n);
            }
        }
    }
}
