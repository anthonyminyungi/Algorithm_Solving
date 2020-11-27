package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Vertrant_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in = "";
        boolean[] prime;
        int cnt;
        while (!(in = br.readLine()).equals("0")) {
            cnt = 0;
            int n = Integer.parseInt(in);
            prime = new boolean[2 * n + 1];
            prime[0] = prime[1] = true;
            for (int i = 2; i * i <= 2 * n; i++) {
                if (!prime[i]) {
                    for (int j = i * i; j <= 2 * n; j += i) {
                        prime[j] = true;
                    }
                }
            }

            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) cnt++;
            }
            bw.append(String.valueOf(cnt)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
