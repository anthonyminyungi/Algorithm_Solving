package com.java;

import java.io.*;

public class avg_score_10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = 0;
        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            int score = Integer.parseInt(a);
            if (score < 40) {
                score = 40;
            }
            total += score;
        }
        bw.append("" + total / 5);
        bw.flush();
        bw.close();

    }
}
