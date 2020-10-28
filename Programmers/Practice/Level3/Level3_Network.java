package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// DFS/BFS
public class Level3_Network {
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution(6, new int[][]{{1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        graph = computers;
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n);
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int j = 0; j < n; j++) {
                if (graph[temp][j] == 1 && !visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
