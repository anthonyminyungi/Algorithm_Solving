package com.java.BOJ.JAVA;

import java.io.*;

public class WhyKMP_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split("-");

        for (int i = 0; i < a.length; i++) {
            bw.append(a[i].charAt(0));
        }
        bw.flush();

    }
}
