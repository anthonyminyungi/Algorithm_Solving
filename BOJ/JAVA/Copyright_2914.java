package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Copyright_2914 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int A = Integer.parseInt(in[0]);
        int I = Integer.parseInt(in[1]);
        System.out.println(A * (I - 1) + 1);
    }
}
