package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Minecraft_18111 {
    static int N, M, B;
    static int[][] map = new int[500][500];
    static int maxH = 0, minH = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nmb = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nmb[0];
        M = nmb[1];
        B = nmb[2];
        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (maxH < map[i][j]) maxH = map[i][j];
                if (minH > map[i][j]) minH = map[i][j];
            }
        }

        int[] res = solve();
        System.out.println(res[0] + " " + res[1]);
    }

    static int[] solve() {
        int ansT = Integer.MAX_VALUE;
        int ansH = Integer.MIN_VALUE;
        for (int target = maxH; target >= minH; target--) {
            int bag = B;
            int t = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int curr = map[i][j];
                    if (curr == target) continue;

                    if (curr > target) {
                        t += (curr - target) * 2;
                        bag += curr - target;
                    } else {
                        t += target - curr;
                        bag -= (target - curr);
                    }
                }
            }
            if (bag < 0) continue;
            if (t < ansT) {
                ansT = t;
                ansH = target;
            }
        }

        return new int[]{ansT, ansH};
    }
}
