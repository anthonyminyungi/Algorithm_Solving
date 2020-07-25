package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class PointSort_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(a[0]);
            arr[i][1] = Integer.parseInt(a[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] == y[0]) {
                    return Integer.compare(x[1], y[1]);
                }
                return Integer.compare(x[0], y[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            bw.append(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
    }
}
