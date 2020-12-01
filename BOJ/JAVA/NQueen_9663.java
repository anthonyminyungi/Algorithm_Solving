package com.algorithms.BOJ.JAVA;

import java.io.*;

public class NQueen_9663 {
    static int[] col;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            col = new int[n];
            col[0] = i;
            dfs(n, 1);
        }

        System.out.println(res);
    }

    private static void dfs(int max, int row) {
        if (row == max) {
            res++;
            col[row - 1] = 0;
            return;
        }

        for (int i = 0; i < max; ++i) {
            col[row] = i;
            if (check(row)) dfs(max, row + 1);
            else col[row] = 0;
        }
        col[row] = 0;
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; ++i) {
            if (col[i] == col[row]) return false;
            if (Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }

        return true;
    }
}
