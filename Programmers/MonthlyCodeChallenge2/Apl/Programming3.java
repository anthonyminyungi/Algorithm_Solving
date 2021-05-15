package com.algorithms.Programmers.MonthlyCodeChallenge2.Apl;

import java.util.*;

// 인접 리스트 활용 DFS
// https://dev-note-97.tistory.com/263?category=884288 참고
public class Programming3 {
    static long[] aa;
    static boolean[] visited;
    static ArrayList<Integer>[] children;
    static long answer;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
        System.out.println(solution(new int[]{-5, 0, 2, 6, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
        System.out.println(solution(new int[]{0, 1, 0}, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(solution(new int[]{0, 0, 0}, new int[][]{{0, 1}, {1, 2}}));
    }

    public static long solution(int[] a, int[][] edges) {
        answer = 0;
        visited = new boolean[a.length];
        children = new ArrayList[a.length];
        aa = new long[a.length];

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            children[i] = new ArrayList<>();
            aa[i] = a[i];
        }

        if (sum != 0) return -1;

        for (int i = 0; i < edges.length; i++) {
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return answer;
    }

    static long dfs(int v) {
        visited[v] = true;

        for (int i = 0; i < children[v].size(); i++) {
            int next = children[v].get(i);

            if (!visited[next]) {
                aa[v] += dfs(next);
            }
        }

        answer += Math.abs(aa[v]);

        return aa[v];
    }
}
