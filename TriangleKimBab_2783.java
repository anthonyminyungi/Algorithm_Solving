package com.java;

import java.io.*;

public class TriangleKimBab_2783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");

        double X = Integer.parseInt(a[0]);
        double Y = Integer.parseInt(a[1]);

        int N = Integer.parseInt(br.readLine());

        double Price = X * 1000 / Y;
        for (int i = 0; i < N; i++) {
            String[] b = br.readLine().split(" ");

            double Xi = Integer.parseInt(b[0]);
            double Yi = Integer.parseInt(b[1]);

            double tempPrice = Xi * 1000 / Yi;

            Price = Math.min(Price, tempPrice);
        }
        bw.append(String.format("%.2f", Price));
        bw.flush();
        bw.close();
        br.close();
    }
}
