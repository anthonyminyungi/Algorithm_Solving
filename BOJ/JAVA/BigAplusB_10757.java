package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.math.BigInteger;

public class BigAplusB_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        BigInteger A = new BigInteger(a[0]);
        BigInteger B = new BigInteger(a[1]);
        BigInteger res = A.add(B);

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
