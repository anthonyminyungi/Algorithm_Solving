package com.java.BOJ.JAVA;

import java.io.*;

public class Bird_1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int time = 1;
        int cnt = 0;
        while (N > 0) {
            if (N >= time) {
                N -= time;
                cnt++;
            } else {
                time = 1;
                N -= time;
                cnt++;
            }
            System.out.println(N);
            time++;
        }
        bw.append(cnt + "");
        bw.flush();
    }
}
