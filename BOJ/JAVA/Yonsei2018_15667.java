package com.java.BOJ.JAVA;

import java.io.*;

public class Yonsei2018_15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int i = 1;
        while (i * (i + 1) + 1 != n) {
            i++;
        }
        bw.append(i + "\n");
        bw.flush();
    }
}
