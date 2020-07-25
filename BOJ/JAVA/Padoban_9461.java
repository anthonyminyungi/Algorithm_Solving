package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Padoban_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] padoban = new long[101];
        padoban[1] = 1;
        padoban[2] = 1;
        padoban[3] = 1;
        for (int i = 4; i <= 100; i++) {
            padoban[i] = padoban[i - 2] + padoban[i - 3];
        }
        String a = br.readLine();
        int a1 = Integer.parseInt(a);
        for (int i = 0; i < a1; i++) {
            int test = Integer.parseInt(br.readLine());
            bw.write(padoban[test] + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
