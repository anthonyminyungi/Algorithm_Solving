package com.java.BOJ.JAVA;

import java.io.*;

public class SmartTrain2_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int passenger = 0;
        int Max = 0;
        for (int i = 0; i < 10; i++) {
            String a = br.readLine();
            String[] aa = a.split(" ");
            int out = Integer.parseInt(aa[0]);
            int in = Integer.parseInt(aa[1]);
            int now = passenger - out + in;
            passenger = now;
            Max = Math.max(Max, now);
        }
        bw.write(Max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
