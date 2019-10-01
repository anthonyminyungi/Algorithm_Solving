package com.java.BOJ.JAVA;

import java.io.*;

public class JerryAndTom_16430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int A = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);
        bw.append((B - A) + " " + B);
        bw.flush();
    }
}
