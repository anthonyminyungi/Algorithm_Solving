package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Plug_2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int total = 1;
        for (int i = 0; i < N; i++) {
            total += Integer.parseInt(br.readLine());
            total -= 1;
        }
        bw.append(total + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
