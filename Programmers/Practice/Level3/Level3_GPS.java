package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 풀이를 봤는데도 무슨소린지 하나도 이해 못했음..
// https://tosuccess.tistory.com/144
// 다시 풀어보기
public class Level3_GPS {
    public static void main(String[] args) {
        System.out.println(solution(7, 10, new int[][]{{1, 2,}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 3, 3, 6, 7}));
        System.out.println(solution(7, 10, new int[][]{{1, 2,}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 6, new int[]{1, 2, 4, 6, 5, 7}));
    }

    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        final int INF = 987654321;
        int[][] dp = new int[k][n + 1];
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edge_list) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                for (int connected : adj[j]) {
                    dp[i][j] = Math.min(dp[i - 1][connected], dp[i][j]);
                }
                dp[i][j] += (gps_log[i] == j) ? 0 : 1;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        answer = dp[k - 1][gps_log[k - 1]];
        return answer >= INF ? -1 : answer;
    }
}
