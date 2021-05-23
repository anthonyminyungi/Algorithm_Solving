package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FindTreesParent_11725 {
    static ArrayList<Integer>[] adj;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        StringTokenizer st;
        int a, b;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }


        bfs(n);
        for (int i = 2; i <= n; i++) {
            bw.append(String.valueOf(parents[i])).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (visited[next]) continue;

                visited[next] = true;
                q.add(next);
                parents[next] = cur;
            }
        }
    }
}
