package com.java.BOJ.JAVA;

import java.io.*;

public class MathIsPhysical_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Integer.parseInt(br.readLine());

        bw.append(n * 4 + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
