package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_PillarAndBarrage {
    static boolean[][] pillar;
    static boolean[][] barrage;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}})));
        System.out.println(Arrays.deepToString(solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}})));
    }

    public static int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 2][n + 2];
        barrage = new boolean[n + 2][n + 2];

        int cnt = 0;
        for (int[] build : build_frame) {
            int x = build[0], y = build[1];
            int type = build[2], cmd = build[3];

            if (type == 0) {
                if (cmd == 1) {
                    if (checkPillar(x, y)) {
                        pillar[x][y] = true;
                        cnt++;
                    }
                } else {
                    pillar[x][y] = false;
                    if (!canDelete(x, y)) pillar[x][y] = true;
                    else cnt--;
                }
            } else {
                if (cmd == 1) {
                    if (checkBarrage(x, y)) {
                        barrage[x][y] = true;
                        cnt++;
                    }
                } else {
                    barrage[x][y] = false;
                    if (!canDelete(x, y)) barrage[x][y] = true;
                    else cnt--;
                }
            }
        }

        int[][] answer = new int[cnt][3];
        cnt = 0;
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) {
                    answer[cnt][0] = x;
                    answer[cnt][1] = y;
                    answer[cnt++][2] = 0;
                }
                if (barrage[x][y]) {
                    answer[cnt][0] = x;
                    answer[cnt][1] = y;
                    answer[cnt++][2] = 1;
                }
            }
        }
        return answer;
    }

    static boolean checkPillar(int x, int y) {
        return (y == 0 || pillar[x][y - 1]) || ((x > 0 && barrage[x - 1][y]) || barrage[x][y]);
    }

    static boolean checkBarrage(int x, int y) {
        return (pillar[x][y - 1] || pillar[x + 1][y - 1]) || (x > 0 && barrage[x - 1][y] && barrage[x + 1][y]);
    }

    static boolean canDelete(int x, int y) {
        for (int i = Math.max(0, x - 1); i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {
                if (pillar[i][j] && !checkPillar(i, j)) return false;
                if (barrage[i][j] && !checkBarrage(i, j)) return false;
            }
        }
        return true;
    }
}
