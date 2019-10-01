package com.java.BOJ.JAVA;

import java.io.*;

public class Facto0Cnt_3474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long e = Long.parseLong(br.readLine());

            int cnt = 0;
            for (int j = 5; j <= e; j *= 5) {
                cnt += e / j;
            }
            bw.append(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
