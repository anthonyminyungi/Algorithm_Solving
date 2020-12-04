package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Bracket_10422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            int N = Integer.parseInt(br.readLine());
            if (N % 2 != 0) {
                bw.append(String.valueOf(0)).append("\n");
            } else {
                long[] dp = new long[N / 2 + 1];
                dp[0] = 1;
                dp[1] = 1;

                for (int i = 2; i <= N / 2; i++) {
                    for (int j = 0; j < i; j++) {
                        dp[i] += dp[j] * dp[i - 1 - j];
                    }
                    dp[i] %= 1000000007;
                }
                bw.append(String.valueOf(dp[N / 2])).append("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
