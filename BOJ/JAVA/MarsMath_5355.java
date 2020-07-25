package com.algorithms.BOJ.JAVA;

import java.io.*;

public class MarsMath_5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] a = br.readLine().split(" ");
            double k = Double.parseDouble(a[0]);
            for (int j = 1; j < a.length; j++) {
                if (a[j].equals("@")) {
                    k *= 3;
                } else if (a[j].equals("%")) {
                    k += 5;
                } else if (a[j].equals("#")) {
                    k -= 7;
                }
            }
            bw.append(String.format("%.2f", k) + "\n");
        }
        bw.flush();
    }
}
