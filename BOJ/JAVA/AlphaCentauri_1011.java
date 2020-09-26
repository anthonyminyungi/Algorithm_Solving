package com.algorithms.BOJ.JAVA;

import java.io.*;

public class AlphaCentauri_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);
            long k = 0, cnt = 0;
            while (true) {
                k++;
                if (k * k > end - start)
                    break;
            }

            if ((k - 1) * (k - 1) == end - start) {
                cnt = 2 * (k - 1) - 1;
            } else if ((k - 1) * (k - 1) + ((k * k - (k - 1) * (k - 1)) / 2) >= end - start) {
                cnt = 2 * k - 2;
            } else
                cnt = 2 * k - 1;

            bw.write(cnt + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
