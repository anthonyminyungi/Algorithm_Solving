package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Leve3_FarthestNode {
    static ArrayList<Integer>[] adj;
    static int maxDist, maxCnt;

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList();
        for (int[] e : edge) {
            adj[e[0] - 1].add(e[1] - 1);
            adj[e[1] - 1].add(e[0] - 1);
        }

        bfs(n, 0);
        bfs(n, 1);
        return maxCnt;
    }

    static void bfs(int n, int flag) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new Node(0, 0));
        visited[0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (flag == 0) {
                maxDist = Math.max(maxDist, cur.dist);
            } else {
                if (cur.dist == maxDist) maxCnt++;
            }

            for (int i : adj[cur.num]) {
                if (visited[i]) continue;

                q.add(new Node(i, cur.dist + 1));
                visited[i] = true;
            }
        }
    }

    static class Node {
        int num, dist;

        Node(int n, int d) {
            this.num = n;
            this.dist = d;
        }
    }
}
