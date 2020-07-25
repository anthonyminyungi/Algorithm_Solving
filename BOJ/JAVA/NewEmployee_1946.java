package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class NewEmployee_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] a = br.readLine().split(" ");
                rank[j][0] = Integer.parseInt(a[0]);
                rank[j][1] = Integer.parseInt(a[1]);
            }
            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] arr1, int[] arr2) {
                    return Integer.compare(arr1[0], arr2[0]);
                }
            });
            int recruit = 1;
            int standard = rank[0][1];
            for (int j = 1; j < N; j++) {
                if (rank[j][1] < standard) {
                    standard = rank[j][1];
                    recruit++;
                }
            }
            bw.write(recruit + "\n");
        }
        bw.flush();
    }
}
