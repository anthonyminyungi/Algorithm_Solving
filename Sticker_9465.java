package com.java;

import java.io.*;

//dp
public class Sticker_9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int n = Integer.parseInt(br.readLine());
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            int[][] grid = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 1; j <= n; j++) {
                grid[0][j] = Integer.parseInt(first[j - 1]);
                grid[1][j] = Integer.parseInt(second[j - 1]);
            }
            dp[0][1] = grid[0][1];
            dp[1][1] = grid[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + grid[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + grid[1][j];
            }
            bw.append(Math.max(dp[0][n], dp[1][n]) + "\n");

        }
        bw.flush();
    }

}
