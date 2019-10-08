package com.java.BOJ.JAVA;

import java.io.*;

public class AngryChangyeong_3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");

        int N = Integer.parseInt(a[0]);
        int W = Integer.parseInt(a[1]);
        int H = Integer.parseInt(a[2]);

        int diag = (int) Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));
        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());

            if (len <= diag)
                bw.append("DA\n");
            else
                bw.append("NE\n");
        }
        bw.flush();
    }
}
