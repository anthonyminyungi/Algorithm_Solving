package com.java.BOJ.JAVA;

import java.io.*;

public class XORXORXOR_12833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");

        long A = Long.parseLong(a[0]);
        long B = Long.parseLong(a[1]);
        long c = Long.parseLong(a[2]);
        while (c > 0) {
            A ^= B;
            c--;
        }
        System.out.println(A);
    }

}
