package com.java;

import java.io.*;
import java.util.Arrays;

public class Percolate_13565 {
    static int[][] grid;
    static int M;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        M = Integer.parseInt(a[0]);
        N = Integer.parseInt(a[1]);
        grid = new int[M][N];
//        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            String b = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(String.valueOf(b.charAt(j)));
            }
        }


        for (int s = 0; s < N; s++) {
            dfs(0, s);
        }
//        for (int i = 0; i < M; i++) {
//            System.out.println(Arrays.toString(grid[i]));
//        }
        if (Arrays.toString(grid[M - 1]).contains("2")) {
            bw.append("YES");
        } else
            bw.append("NO");

        bw.flush();
    }

    static void dfs(int i, int j) {
        if (i < M && j < N && i >= 0 && j >= 0 && grid[i][j] != 2 && grid[i][j] != 1) {
            grid[i][j] = 2;

            if (i + 1 < M) {
                if (grid[i + 1][j] == 0)
                    dfs(i + 1, j);
            }
            if (i - 1 >= 0) {
                if (grid[i - 1][j] == 0)
                    dfs(i - 1, j);
            }
            if (j + 1 < N) {
                if (grid[i][j + 1] == 0)
                    dfs(i, j + 1);
            }
            if (j - 1 >= 0) {
                if (grid[i][j - 1] == 0)
                    dfs(i, j - 1);
            }
        }

    }

}
