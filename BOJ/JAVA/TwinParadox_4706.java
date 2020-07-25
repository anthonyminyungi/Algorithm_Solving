package com.algorithms.BOJ.JAVA;

import java.io.*;

public class TwinParadox_4706 {
    //이건 문제가 완전 엉터리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in = "";
        while (!(in = br.readLine()).equals("0 0")) {
            String[] a = in.split(" ");
            double ta = Double.parseDouble(a[0]);
            double tb = Double.parseDouble(a[1]);
            bw.append(String.format("%.3f", Math.sqrt(1 - Math.pow(tb / ta, 2))) + "\n");
        }
        bw.flush();
    }
}
