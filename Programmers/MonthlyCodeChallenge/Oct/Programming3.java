package com.algorithms.Programmers.MonthlyCodeChallenge.Oct;

import java.util.*;

// 트리의 지름 BFS
// Related to : BOJ 1167
public class Programming3 {
    static Map<Integer, List<Integer>> lists;

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(5, new int[][]{{1, 5}, {2, 5}, {3, 5}, {4, 5}}));
    }

    public static int solution(int n, int[][] edges) {
        lists = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            lists.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }

        List<int[]> b = bfs(n, 1);
        List<int[]> e = bfs(n, b.get(b.size() - 1)[0]);

        if (b.get(b.size() - 1)[1] == b.get(b.size() - 2)[1])
            return e.get(e.size() - 1)[1];
        else
            return e.get(e.size() - 2)[1];
    }

    static List<int[]> bfs(int N, int start) {
        boolean[] visited = new boolean[N + 1];
        List<int[]> dist = new ArrayList<>();
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] v = queue.pollFirst();
            dist.add(new int[]{v[0], v[1]});

            for (int n : lists.get(v[0])) {
                if (!visited[n]) {
                    queue.add(new int[]{n, v[1] + 1});
                    visited[n] = true;
                }
            }
        }
        return dist;
    }
}