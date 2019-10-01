package com.java.BOJ.JAVA;

import java.io.*;

public class Moma_12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        long[] cards = new long[n];
        if (n == 1)
            result = Integer.parseInt(a[0]);
        else if (n == 2)
            result += Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
        else if (n > 2) {
            long max = 0;
            long Sum = 0;
            for (int i = 0; i < n; i++) {
                cards[i] = Integer.parseInt(a[i]);
                max = Math.max(max, cards[i]);
                Sum += cards[i];
            }
            bw.append((Sum + max * (n - 2)) + "");
        }
        bw.flush();
    }
}
