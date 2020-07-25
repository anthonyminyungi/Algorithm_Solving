package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class IntegerTriangle_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (j < a.length) {
                    triangle[i][j] = Integer.parseInt(a[j]);
                } else {
                    triangle[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || triangle[i][j] == -1)
                    break;
                if (j == 0)
                    triangle[i][j] += triangle[i - 1][j];
                else
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }
        }

        Arrays.sort(triangle[n - 1]);
        bw.append(String.valueOf(triangle[n - 1][n - 1]));
        bw.flush();
        bw.close();
        br.close();
    }
}
