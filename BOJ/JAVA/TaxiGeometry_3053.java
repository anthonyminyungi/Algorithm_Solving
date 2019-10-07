package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxiGeometry_3053 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        double r = Double.parseDouble(br.readLine());
//
//        bw.append(String.format("%.6f", r * r * 3.14159265358979323846264338327950288) + "\n");
//        bw.append(String.format("%.6f", r * r * 2) + "");
//
//        bw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double r = Double.parseDouble(br.readLine());
        System.out.println(r * r * 3.14159265358979);
        System.out.println(r * r * 2.0 + "");
    }
}
