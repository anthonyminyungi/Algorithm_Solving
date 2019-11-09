package com.java.BOJ.JAVA;

import java.io.*;
import java.util.StringTokenizer;

public class MatrixMultiply_2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int m2 = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr2 = new int[m2][k];
        for (int i = 0; i < m2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arr3 = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int sum = 0;
                for (int l = 0; l < m2; l++) {
                    sum += arr1[i][l] * arr2[l][j];
                }
                arr3[i][j] = sum;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                bw.append(arr3[i][j] + " ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
