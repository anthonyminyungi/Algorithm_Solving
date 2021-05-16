package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Tetromino_14500 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] square = new int[n][m];

        int ans = Integer.MIN_VALUE;
        int[][][] tetrominos = {
                {{0, 1}, {0, 2}, {0, 3}}, {{1, 0}, {2, 0}, {3, 0}}, {{0, 1}, {1, 0}, {1, 1}},
                {{1, 0}, {2, 0}, {2, 1}}, {{1, 0}, {2, 0}, {2, -1}}, {{0, 1}, {0, 2}, {1, 2}}, {{0, 1}, {0, 2}, {-1, 2}},
                {{-1, 0}, {-2, 0}, {-2, 1}}, {{-1, 0}, {-2, 0}, {-2, -1}}, {{0, -1}, {0, -2}, {1, -2}}, {{0, -1}, {0, -2}, {-1, -2}},
                {{0, 1}, {-1, 1}, {-1, 2}}, {{1, 0}, {1, 1}, {2, 1}}, {{1, 0}, {1, -1}, {2, -1}}, {{0, -1}, {-1, -1}, {-1, -2}},
                {{0, 1}, {1, 1}, {0, 2}}, {{1, 0}, {1, 1}, {2, 0}}, {{0, 1}, {-1, 1}, {0, 2}}, {{1, 0}, {1, -1}, {2, 0}}
        };
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = square[i][j];

                for (int t = 0; t < tetrominos.length; t++) {
                    int nx1 = i + tetrominos[t][0][0];
                    int ny1 = j + tetrominos[t][0][1];
                    int nx2 = i + tetrominos[t][1][0];
                    int ny2 = j + tetrominos[t][1][1];
                    int nx3 = i + tetrominos[t][2][0];
                    int ny3 = j + tetrominos[t][2][1];

                    if (nx1 < 0 || nx1 > n - 1 || ny1 < 0 || ny1 > m - 1) continue;
                    if (nx2 < 0 || nx2 > n - 1 || ny2 < 0 || ny2 > m - 1) continue;
                    if (nx3 < 0 || nx3 > n - 1 || ny3 < 0 || ny3 > m - 1) continue;

                    ans = Math.max(cur + square[nx1][ny1] + square[nx2][ny2] + square[nx3][ny3], ans);
                }
            }
        }

        System.out.println(ans);
    }
}
