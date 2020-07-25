package com.algorithms.BOJ.JAVA;

import java.io.*;

// dp...
public class ContinuousSum_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] dp = new int[in.length];
        dp[0] = Integer.parseInt(in[0]);
        int gmax = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            int cur = Integer.parseInt(in[i]);
            dp[i] = Math.max(dp[i - 1] + cur, cur);
            gmax = Math.max(dp[i], gmax);
        }
        System.out.println(Math.max(gmax, dp[0]));
    }
}
