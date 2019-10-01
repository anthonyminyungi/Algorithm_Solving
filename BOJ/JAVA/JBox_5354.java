package com.java.BOJ.JAVA;

import java.io.*;

public class JBox_5354 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j = 1; j <= a; j++) {
                for (int k = 1; k <= a; k++) {
                    if (k > 1 && k < a && j > 1 && j < a)
                        bw.append("J");
                    else
                        bw.append("#");
                }
                bw.append("\n");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
