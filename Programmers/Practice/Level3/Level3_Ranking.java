package com.algorithms.Programmers.Practice.Level3;


// 플로이드-와샬
public class Level3_Ranking {
    static final int INF = 987654321;

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF;
            }
        }

        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                    if (graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean hasInf = false;
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] == INF) {
                    hasInf = true;
                    break;
                }
            }
            answer += hasInf ? 0 : 1;
        }

        return answer;
    }
}
