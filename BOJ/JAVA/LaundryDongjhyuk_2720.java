package com.java.BOJ.JAVA;

import java.io.*;

public class LaundryDongjhyuk_2720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] cents = {1, 5, 10, 25};
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int g = Integer.parseInt(br.readLine());
            for (int j = 3; j >= 0; j--) {
                int cnt = 0;
                while (cents[j] <= g) {
                    g -= cents[j];
                    cnt++;
                }
                bw.append(cnt + " ");
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
