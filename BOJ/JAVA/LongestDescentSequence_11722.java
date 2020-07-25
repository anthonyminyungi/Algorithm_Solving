package com.algorithms.BOJ.JAVA;

import java.io.*;

//Dynamic Programming. 다시 보기.
public class LongestDescentSequence_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        String[] a = br.readLine().split(" ");
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(a[i]);
        }

        for (int i = 0; i < n; i++) {
            int min = 0;
            for (int j = 0; j < i; j++) {
                if (A[i] < A[j] && min < dp[j])
                    min = dp[j];
            }
            dp[i] = min + 1;
            if (max < dp[i])
                max = dp[i];
        }
        bw.append(max + "");
        bw.flush();
    }
}
