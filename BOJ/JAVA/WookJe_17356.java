package com.algorithms.BOJ.JAVA;

import java.io.*;

public class WookJe_17356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        double A = Integer.parseInt(a[0]);
        double B = Integer.parseInt(a[1]);
        double M = (B - A) / 400;
        double pow = Math.pow(10, M);
        double res = pow + 1;

        bw.append((1 / res) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
