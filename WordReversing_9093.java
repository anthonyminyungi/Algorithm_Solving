package com.java;

import java.io.*;

public class WordReversing_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            String[] a = br.readLine().split(" ");
            for (int i = 0; i < a.length; i++) {
                String reversed = (new StringBuffer(a[i])).reverse().toString();

                bw.append(reversed + " ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
