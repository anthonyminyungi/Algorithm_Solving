package com.algorithms.BOJ.JAVA;

import java.io.*;

public class DoYouLikeBunsu_10474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a;
        while (!(a = br.readLine()).equals("0 0")) {
            int q = Integer.parseInt(a.split(" ")[0]);
            int p = Integer.parseInt(a.split(" ")[1]);
            bw.append((q / p) + " " + (q % p) + " / " + (p) + "\n");
        }
        bw.flush();
    }
}
