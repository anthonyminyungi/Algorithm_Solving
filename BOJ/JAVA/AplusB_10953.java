package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.math.BigInteger;

public class AplusB_10953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] a = br.readLine().split(" ");
        BigInteger A = new BigInteger((a[0]));
        BigInteger B = new BigInteger((a[1]));
        bw.append(A.add(B) + "\n");

        bw.flush();
    }
}
