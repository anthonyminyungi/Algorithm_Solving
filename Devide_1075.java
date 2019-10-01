package com.java;

import java.io.*;

public class Devide_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        N = N / 100;
        N = N * 100;

        int i;
        for (i = 0; i < 100; i++) {
            if ((N + i) % F == 0)
                break;
        }
        if (i / 10 > 0) {
            bw.append(i + "");
        } else
            bw.append("0" + i);

        bw.flush();
        bw.close();
        br.close();
    }
}
