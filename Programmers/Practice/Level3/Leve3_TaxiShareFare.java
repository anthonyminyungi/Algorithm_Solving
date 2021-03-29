package com.algorithms.Programmers.Practice.Level3;

public class Leve3_TaxiShareFare {
    static final int INF = 40000000;
    static int[][] distances = new int[200][200];

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}}));
        System.out.println(solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}}));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) distances[i][j] = 0;
                else distances[i][j] = INF;
            }
        }

        for (int[] edge : fares) {
            distances[edge[0] - 1][edge[1] - 1] = distances[edge[1] - 1][edge[0] - 1] = edge[2];
        }

        floyd(n);

        --s;
        --a;
        --b;

        int answer = INF;
        for (int k = 0; k < n; k++) {
            answer = Math.min(answer, distances[s][k] + distances[k][a] + distances[k][b]);
        }

        return answer;
    }

    static void floyd(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j])
                        distances[i][j] = distances[i][k] + distances[k][j];
                }
            }
        }
    }
}
