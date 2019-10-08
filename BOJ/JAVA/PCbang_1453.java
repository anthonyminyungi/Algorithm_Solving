package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class PCbang_1453 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");

        boolean[] seat = new boolean[101];
        Arrays.fill(seat, false);
        int rejected = 0;
        for (int i = 0; i < n; i++) {
            int sit = Integer.parseInt(a[i]);
            if (!seat[sit]) {
                seat[sit] = true;
            } else {
                rejected++;
            }
        }
        bw.append(rejected + "");
        bw.flush();

    }
}
