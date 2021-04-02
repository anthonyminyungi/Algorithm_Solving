package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FishingKing_17143 {
    static int R, C, M;
    static Shark[][] arr = new Shark[100][100];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rcm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = rcm[0];
        C = rcm[1];
        M = rcm[2];
        for (int i = 0; i < M; i++) {
            int[] sharkInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = sharkInfo[0] - 1, c = sharkInfo[1] - 1, s = sharkInfo[2], d = sharkInfo[3] - 1, z = sharkInfo[4];

            arr[r][c] = new Shark(s, d, z);
        }

        System.out.println(solve());
    }

    static int solve() {
        int sum = 0;
        Shark[][] backup = new Shark[100][100];
        for (int t = 0; t < C; t++) {
            for (int i = 0; i < R; i++) {
                if (arr[i][t] != null) {
                    sum += arr[i][t].z;
                    arr[i][t] = null;
                    break;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    backup[i][j] = arr[i][j];
                    arr[i][j] = null;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    Shark curr = backup[i][j];
                    if (curr != null) {
                        int nr = i + curr.s * dr[curr.d];
                        int nc = j + curr.s * dc[curr.d];

                        if (nr < 0) {
                            nr = -nr;
                            curr.d = 1;
                        }
                        if (nr > R - 1) {
                            int a = nr / (R - 1), b = nr % (R - 1);
                            if (a % 2 == 0) nr = b;
                            else {
                                nr = (R - 1) - b;
                                curr.d = 0;
                            }
                        }
                        if (nc < 0) {
                            nc = -nc;
                            curr.d = 2;
                        }
                        if (nc > C - 1) {
                            int a = nc / (C - 1), b = nc % (C - 1);
                            if (a % 2 == 0) nc = b;
                            else {
                                nc = (C - 1) - b;
                                curr.d = 3;
                            }
                        }

                        if (arr[nr][nc] == null || (arr[nr][nc] != null && arr[nr][nc].z < curr.z))
                            arr[nr][nc] = curr;
                    }
                }
            }
        }
        return sum;
    }

    static class Shark {
        int s, d, z;

        Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
