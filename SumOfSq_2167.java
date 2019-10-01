package com.java;

import java.io.*;

public class SumOfSq_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int M = Integer.parseInt(a[1]);

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(b[j]);
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            int res = 0;
            String[] c = br.readLine().split(" ");
            int i = Integer.parseInt(c[0]) - 1;
            int j = Integer.parseInt(c[1]) - 1;
            int x = Integer.parseInt(c[2]) - 1;
            int y = Integer.parseInt(c[3]) - 1;

            for (int in = i; in <= x; in++) {
                for (int jn = j; jn <= y; jn++) {
                    res += arr[in][jn];
                }
            }
            bw.append(res + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
