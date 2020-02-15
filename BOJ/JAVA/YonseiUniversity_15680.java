package com.java.BOJ.JAVA;

import java.io.*;

public class YonseiUniversity_15680 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(br.readLine().equals("0") ? "YONSEI" : "Leading the Way to the Future");
        bw.flush();
    }
}
