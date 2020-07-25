package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ReverseBinary_11179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());

        String a = Long.toBinaryString(N);
        String temp = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            temp = temp + a.charAt(i);
        }
        bw.append(Long.parseLong(temp, 2) + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
