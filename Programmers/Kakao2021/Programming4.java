package com.algorithms.Programmers.Kakao2021;

import java.util.*;

// 효율성 5/30
public class Programming4 {
    private static final int INF = 1000000000;
    static int[][] dist;

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n + 1][n + 1];
        List<Integer> money = new ArrayList<>();
        int[] nodes = new int[n];

        initialize(n, fares);
        for (int i = 0; i < n; i++) {
            if ((i + 1) != s) {
                nodes[i] = djikstra(dist, n, s, (i + 1));
                if (nodes[i] == INF)
                    nodes[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int m = 0;
            if ((i + 1) != s) {
                m = nodes[i] + djikstra(dist, n, (i + 1), a);
                m = m + djikstra(dist, n, (i + 1), b);
                money.add(m);
            }
        }

        money.add(djikstra(dist, n, s, a) + djikstra(dist, n, s, b));

        Collections.sort(money);

        return money.get(0);
    }

    static void initialize(int n, int[][] fares) {
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], INF);
        }
        for (int i = 0; i < fares.length; i++) {
            int[] l = fares[i];
            dist[l[0]][l[1]] = Math.min(dist[l[0]][l[1]], l[2]);
            dist[l[1]][l[0]] = Math.min(dist[l[1]][l[0]], l[2]);
            dist[l[0]][l[0]] = 0;
            dist[l[1]][l[1]] = 0;
        }
    }

    private static int djikstra(int[][] dist, int n, int src, int dest) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (src != i && dist[src][i] < INF) {
                priorityQueue.offer(new Node(i, dist[src][i]));
            }
        }
        while (!priorityQueue.isEmpty()) {
            Node next = priorityQueue.poll();
            int nidx = next.getIdx();
            int ndist = next.getVal();
            for (int i = 1; i <= n; i++) {
                if (dist[nidx][i] != INF && ndist + dist[nidx][i] < dist[src][i]) {
                    dist[src][i] = ndist + dist[nidx][i];
                    priorityQueue.offer(new Node(i, dist[src][i]));
                }
            }
        }
        return dist[src][dest];
    }

    private static class Node implements Comparable<Node> {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        int getIdx() {
            return idx;
        }

        int getVal() {
            return val;
        }

        @Override
        public int compareTo(Node o) {
            return this.getVal() - o.getVal();
        }
    }
}
