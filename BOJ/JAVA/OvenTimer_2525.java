package com.algorithms.BOJ.JAVA;

import java.io.*;

public class OvenTimer_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int h = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int c = Integer.parseInt(br.readLine());
        m += c;
        h += (m / 60);
        m %= 60;
        if (h > 23) h -= 24;
        System.out.println(h + " " + m);
    }
}
