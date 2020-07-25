package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GetPrimeNumber_1929 {
    static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int M = Integer.parseInt(in[0]);
        int N = Integer.parseInt(in[1]);
        prime = new boolean[N + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                    System.out.println(j);
                }
            }
        }
        for (int i = M; i <= N; i++) {
            if (!prime[i]) bw.append(String.valueOf(i)).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
