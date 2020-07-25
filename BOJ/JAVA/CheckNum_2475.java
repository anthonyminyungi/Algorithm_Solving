package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CheckNum_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String[] aa = a.split(" ");
        int sqnum = 0;
        for (int i = 0; i < 5; i++) {
            sqnum += (int) Math.pow(Integer.parseInt(aa[i]), 2);
        }
        bw.append("" + sqnum % 10);
        bw.flush();
        bw.close();
        br.close();
    }
}
