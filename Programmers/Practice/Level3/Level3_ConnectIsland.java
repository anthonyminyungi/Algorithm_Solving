package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// Greedy
// MST - Kruskal
// Union-Find
// 출처 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%84%AC-%EC%97%B0%EA%B2%B0%ED%95%98%EA%B8%B0-Java
public class Level3_ConnectIsland {
    static PriorityQueue<Edge> adj;
    static int[] parent;

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();

        for (int[] cost : costs) {
            adj.offer(new Edge(cost[0], cost[1], cost[2]));
        }

        for (int i = 0; i < n; i++) parent[i] = i;

        while (!adj.isEmpty()) {
            Edge edge = adj.poll();
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                answer += edge.cost;
            }
        }

        return answer;
    }

    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int f, int t, int c) {
            this.from = f;
            this.to = t;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}
