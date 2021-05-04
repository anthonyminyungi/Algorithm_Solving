package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ColoredPaper_2630 {
    static int[][] paper;
    static int blueCnt;
    static int whiteCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dnc(0, n, 0, n);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void dnc(int xs, int xe, int ys, int ye) {
        int sum = 0;
        for (int i = xs; i < xe; i++) {
            for (int j = ys; j < ye; j++) {
                if (paper[i][j] == 1) sum += 1;
            }
        }

        if (sum == (ye - ys) * (xe - xs)) {
            blueCnt += 1;
            return;
        } else if (sum == 0) {
            whiteCnt += 1;
            return;
        } else {
            int midx = (xs + xe) / 2, midy = (ys + ye) / 2;
            if (midx == 0 || midy == 0) return;

            dnc(xs, midx, ys, midy);
            dnc(xs, midx, midy, ye);
            dnc(midx, xe, ys, midy);
            dnc(midx, xe, midy, ye);
        }
    }
}
