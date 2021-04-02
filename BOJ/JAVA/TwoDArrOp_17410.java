package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class TwoDArrOp_17410 {
    static int r, c, k;
    static int[][] arr = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rck = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        r = rck[0] - 1;
        c = rck[1] - 1; // index 0부터 활용하기 위함
        k = rck[2];

        for (int i = 0; i < 3; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i][0] = row[0];
            arr[i][1] = row[1];
            arr[i][2] = row[2];
        }

        System.out.println(solve());
    }

    static int solve() {
        int rsize = 3, csize = 3;
        for (int t = 0; t <= 100; t++) {
            if (arr[r][c] == k) return t;
            if (rsize >= csize) {
                for (int i = 0; i < rsize; i++) {
                    List<Number> numberList = new ArrayList<>();
                    int[] cnt = new int[101];
                    for (int j = 0; j < csize; j++) {
                        cnt[arr[i][j]]++;
                    }

                    for (int c = 1; c <= 100; c++) {
                        if (cnt[c] > 0) numberList.add(new Number(c, cnt[c]));
                    }
                    numberList.sort(Comparator.comparingInt(lhs -> lhs.c));
                    int idx = 0;
                    for (Number num : numberList) {
                        if (idx >= 99) break;
                        arr[i][idx++] = num.n;
                        arr[i][idx++] = num.c;
                    }
                    csize = Math.max(csize, idx);
                    for (; idx < 100; idx++) {
                        arr[i][idx] = 0;
                    }
                }
            } else {
                for (int j = 0; j < csize; j++) {
                    List<Number> numberList = new ArrayList<>();
                    int[] cnt = new int[101];
                    for (int i = 0; i < csize; i++) {
                        cnt[arr[i][j]]++;
                    }

                    for (int c = 1; c <= 100; c++) {
                        if (cnt[c] > 0) numberList.add(new Number(c, cnt[c]));
                    }
                    numberList.sort(Comparator.comparingInt(lhs -> lhs.c));
                    int idx = 0;
                    for (Number num : numberList) {
                        if (idx >= 99) break;
                        arr[idx++][j] = num.n;
                        arr[idx++][j] = num.c;
                    }
                    rsize = Math.max(rsize, idx);
                    for (; idx < 100; idx++) {
                        arr[idx][j] = 0;
                    }
                }
            }
        }
        return -1;
    }

    static class Number {
        int n, c;

        Number(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }
}
