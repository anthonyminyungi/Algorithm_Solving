package com.java.BOJ.JAVA;

import java.io.*;

public class KoreaOfficialWine_16673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int C = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);
        int P = Integer.parseInt(a[2]);
        int sum = 0;
        for (int i = 1; i <= C; i++) {
            sum += (K * i) + (int) (P * Math.pow(i, 2));
        }
        bw.append(sum + "\n");
        bw.flush();
    }
}
