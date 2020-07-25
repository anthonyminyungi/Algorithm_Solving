package com.algorithms.BOJ.JAVA;

import java.io.*;

public class KQLBKP_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] chess = {1, 1, 2, 2, 2, 8};

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < 6; i++) {
            int t = Integer.parseInt(a[i]);

            bw.append((chess[i] - t) + " ");
        }
        bw.flush();

    }
}
