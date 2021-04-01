package com.algorithms.Programmers.Practice.Level2;

public class Level2_Delivery {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println(solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }

    public static int solution(int N, int[][] road, int K) {
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = 500001; // K는 50만 이하이므로 초기 정점 간 거리를 최대값 이상으로 설정.
            }
        }

        for (int[] ints : road) {
            if (map[ints[0] - 1][ints[1] - 1] < ints[2])
                continue; // 두 정점 간 연결하는 길이 두개 이상일 수 있으므로 이미 더 작은 수를 가지고 있으면 무시함.
            map[ints[0] - 1][ints[1] - 1] = ints[2];
            map[ints[1] - 1][ints[0] - 1] = ints[2];
        }

        for (int k = 0; k < N; k++) { // 플로이드 와샬
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (map[0][i] <= K) answer++;
        }

        return answer;
    }
}
