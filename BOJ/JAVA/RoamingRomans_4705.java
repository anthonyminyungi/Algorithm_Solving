package com.algorithms.BOJ.JAVA;

import java.io.*;

public class RoamingRomans_4705 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double convert = 5280.0 / 4854.0;

        String a;
        while (!(a = br.readLine()).equals("0.0")) {
            double in = Double.parseDouble(a);
            bw.append(String.format("%.2f", in)).append(" English miles equals ").append(String.format("%.2f", in * convert)).append(" Roman miles or ").append(String.valueOf(Math.round((in * convert) * 1000))).append(" paces.\n");
        }
        bw.flush();

    }
}
