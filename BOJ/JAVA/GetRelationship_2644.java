package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class GetRelationship_2644 {
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken()), child = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        System.out.println(bfs(parent, child, n));
    }

    static int bfs(int p, int c, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int answer = 0;
        q.add(new int[]{p, 0});
        visited[p] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == c) {
                answer = cur[1];
                break;
            }

            for (int child : adj[cur[0]]) {
                if (visited[child]) continue;

                visited[child] = true;
                q.add(new int[]{child, cur[1] + 1});
            }
        }

        return answer;
    }
}
