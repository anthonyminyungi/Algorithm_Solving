package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ByeFineDust_17144 {
    static int R, C, T;
    static int[][] arr = new int[50][50];
    static int cleanRow;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rct = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = rct[0];
        C = rct[1];
        T = rct[2];

        for (int i = 0; i < R; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = row[j];
                if (arr[i][j] == -1 && arr[i - 1][j] == -1)
                    cleanRow = i - 1;

            }
        }
        System.out.println(solve());
    }

    static int solve() {
        for (int t = 0; t < T; t++) {
            int[][] diffusion = new int[50][50];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] < 5) continue;
                    int quantity = arr[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k], nc = j + dc[k];

                        if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1) continue;
                        if (arr[nr][nc] == -1) continue;

                        diffusion[nr][nc] += quantity;
                        diffusion[i][j] -= quantity;
                    }
                }
            }

            for (int i = 0; i < R; i++)
                for (int j = 0; j < C; j++)
                    arr[i][j] += diffusion[i][j];

            for (int i = cleanRow - 1; i >= 1; i--)
                arr[i][0] = arr[i - 1][0];
            for (int j = 0; j <= C - 2; j++)
                arr[0][j] = arr[0][j + 1];
            for (int i = 0; i <= cleanRow - 1; i++)
                arr[i][C - 1] = arr[i + 1][C - 1];
            for (int j = C - 1; j >= 2; j--)
                arr[cleanRow][j] = arr[cleanRow][j - 1];
            arr[cleanRow][1] = 0;

            for (int i = cleanRow + 2; i <= R - 2; i++)
                arr[i][0] = arr[i + 1][0];
            for (int j = 0; j <= C - 2; j++)
                arr[R - 1][j] = arr[R - 1][j + 1];
            for (int i = R - 1; i >= cleanRow + 2; i--)
                arr[i][C - 1] = arr[i - 1][C - 1];
            for (int j = C - 1; j >= 2; j--)
                arr[cleanRow + 1][j] = arr[cleanRow + 1][j - 1];
            arr[cleanRow + 1][1] = 0;

        }
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) sum += arr[i][j];
            }
        }

        return sum;
    }
}
