package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class TreeDiameter_1967 {
    static ArrayList<Node>[] adj;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int s, e, w;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[s].add(new Node(e, w));
            adj[e].add(new Node(s, w));
        }

        int start = 1;
        bfs(start, n);
        for (int i = 0; i <= n; i++) {
            if (dist[start] < dist[i])
                start = i;
        }

        bfs(start, n);
        int ans = -987654321;
        for (int i = 0; i <= n; i++) {
            if (dist[i] > ans) ans = dist[i];
        }

        System.out.println(ans);
    }

    static void bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node node : adj[cur]) {
                if (!visited[node.dst]) {
                    visited[node.dst] = true;
                    q.add(node.dst);
                    dist[node.dst] = dist[cur] + node.weight;
                }
            }
        }
    }

    static class Node {
        int dst, weight;

        Node(int d, int w) {
            this.dst = d;
            this.weight = w;
        }
    }
}
