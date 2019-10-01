package com.java.BOJ.JAVA;

import java.io.*;

public class Coin0_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int K = Integer.parseInt(a[1]);

        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        int temp = K;
        int needed = 0;
        while (temp > 0) {
            if (money[N - 1] < temp) {
                int div = temp / money[N - 1];
                temp -= money[N - 1] * div;
                needed += div;
            } else {
                for (int i = 1; i < N; i++) {
                    if (money[i] > temp) {
                        temp -= money[i - 1];
                        needed++;
                        break;
                    }
                }
            }
        }
        bw.write(needed + "");
        bw.flush();
    }
}
