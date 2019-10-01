package com.java.BOJ.JAVA;

import java.io.*;

public class RGBStreet_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] grid = new int[N + 1][3];
        grid[0][0] = 0;
        grid[0][1] = 0;
        grid[0][2] = 0;
//        String[] a = br.readLine().split(" ");
//        int R = Integer.parseInt(a[0]);
//        int G = Integer.parseInt(a[1]);
//        int B = Integer.parseInt(a[2]);
//        grid[1][0] = R;
//        grid[1][1] = G;
//        grid[1][2] = B;
        int sums = 0;
        for (int i = 1; i <= N; i++) {
            String[] a = br.readLine().split(" ");
            int R = Integer.parseInt(a[0]);
            int G = Integer.parseInt(a[1]);
            int B = Integer.parseInt(a[2]);
            grid[i][0] = R + Math.min(grid[i - 1][1], grid[i - 1][2]);
            grid[i][1] = G + Math.min(grid[i - 1][0], grid[i - 1][2]);
            grid[i][2] = B + Math.min(grid[i - 1][1], grid[i - 1][0]);
        }
//        for (int i = 0; i <= N; i++) {
//            System.out.println( Arrays.toString(grid[i]));
//        }
        sums = Math.min(grid[N][0], grid[N][1]);
        sums = Math.min(sums, grid[N][2]);
        bw.write(sums + "");
        bw.flush();
    }
}
