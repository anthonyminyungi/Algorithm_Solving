package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Microwave_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = 300, b = 60, c = 10;
        int t = Integer.parseInt(br.readLine());

        if (t % 10 != 0) {
            System.out.println(-1);
        } else {
            int ac = 0, bc = 0, cc = 0;
            if (t / a > 0) {
                ac += t / a;
                t = t - (t / a) * a;
            }
            if (t / b > 0) {
                bc += t / b;
                t = t - (t / b) * b;
            }
            if (t / c > 0) {
                cc += t / c;
                t = t - (t / c) * c;
            }
            System.out.println(ac + " " + bc + " " + cc);
        }
    }
}
