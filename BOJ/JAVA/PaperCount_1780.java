package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class PaperCount_1780 {
    static int[][] paper;
    static int[] cnt = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dnc(0, n, 0, n);
        System.out.println(cnt[2]);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }

    static void dnc(int xs, int xe, int ys, int ye) {
        int sum = 0;

        int c = paper[xs][ys];
        for (int i = xs; i < xe; i++) {
            for (int j = ys; j < ye; j++) {
                if (paper[i][j] == c) sum++;
            }
        }
        if (sum == (xe - xs) * (ye - ys)) {
            if (c == -1) cnt[2]++;
            else cnt[c]++;

            return;
        }

        int stridex = (xe - xs) / 3, stridey = (ye - ys) / 3;
        int cut1x = xs + stridex, cut2x = xe - stridex;
        int cut1y = ys + stridey, cut2y = ye - stridey;
        if (cut1x == 0 || cut2x == 0 || cut1y == 0 || cut2y == 0) return;

        dnc(xs, cut1x, ys, cut1y);
        dnc(xs, cut1x, cut1y, cut2y);
        dnc(xs, cut1x, cut2y, ye);
        dnc(cut1x, cut2x, ys, cut1y);
        dnc(cut1x, cut2x, cut1y, cut2y);
        dnc(cut1x, cut2x, cut2y, ye);
        dnc(cut2x, xe, ys, cut1y);
        dnc(cut2x, xe, cut1y, cut2y);
        dnc(cut2x, xe, cut2y, ye);
    }
}
