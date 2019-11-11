package com.java.BOJ.JAVA;

import java.io.*;

public class NormalKnapsack_12865 {
    private static int[][] K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);

        int[] wt = new int[N];
        int[] val = new int[N];

        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            wt[i] = Integer.parseInt(in[0]);
            val[i] = Integer.parseInt(in[1]);
        }
        System.out.println(knapSack(K, wt, val, N));
    }

    private static int knapSack(int W, int[] weight, int[] val, int n) {
        K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (weight[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

}
