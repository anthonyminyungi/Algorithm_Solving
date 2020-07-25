package com.algorithms.BOJ.JAVA;

import java.io.*;

public class SoobinSooyeol_10539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");

        int[] B = new int[N];
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(a[i]);
        }
        A[0] = B[0];
        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += A[j];
            }
            A[i] = ((i + 1) * B[i]) - sum;
        }
        for (int i = 0; i < N; i++) {
            bw.append(A[i] + " ");
        }
        bw.flush();


    }

}
