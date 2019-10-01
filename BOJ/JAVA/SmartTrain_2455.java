package com.java.BOJ.JAVA;

import java.io.*;

public class SmartTrain_2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int passenger = 0;
        for (int i = 0; i < 4; i++) {
            String a = br.readLine();
            String[] aa = a.split(" ");
            int out = Integer.parseInt(aa[0]);
            int in = Integer.parseInt(aa[1]);
            passenger = passenger > passenger - out + in ? passenger : passenger - out + in;
        }
        bw.append("" + passenger);
        bw.flush();
        bw.close();
        br.close();
    }
}
