package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

/**
 * 이 로그들을 고친다고 하면, 다음 로그는 앞서 고쳐진 로그의 영향을 받게된다.
 * 입력되는 데이터에서 항상 모든 거점 간 경로가 있음이 보장되지 않는다고 문제에서 모든 노드가 연결되어 있지 않다고 했기 때문이다. 그래서 DP로 풀이해야 한다.
 * 몇번째 어떤 노드를 고쳤는지, 그리고 그때의 최소 횟수는 어떤지를 메모이제이션 해야 한다.
 * 즉, DP[i][j] : i번째 j 노드로 오면서 최소로 고친 횟수 -> 2차원 배열로 메모이제이션 한다.
 * DP[i][j]는 DP[i - 1][j로 올수 있는 노드]의 최소값을 가져오고, 그 후에 현재 위치를 고친 횟수를 더해주게 된다.
 * 점화식 - DP[i][j] = min(DP[i - 1][인접 노드들], DP[i - 1][j]) + (log[i] == j ? 0 : 1)
 * 출처: https://softworking.tistory.com/417
 * 참고: https://tosuccess.tistory.com/144
 */
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
