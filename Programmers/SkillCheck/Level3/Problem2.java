package com.algorithms.Programmers.SkillCheck.Level3;

import java.util.*;

public class Problem2 {
    static boolean[] visited;
    static int[][] networks;

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        networks = computers.clone();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    static void bfs(int start) {
        int len = networks.length;
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < len; i++) {
                if (cur == i) continue;
                if (visited[i]) continue;
                if (networks[cur][i] == 0) continue;

                visited[i] = true;
                q.add(i);
            }
        }
    }
}
