package com.java.BOJ.JAVA;

import java.io.*;

public class BonusScore_17389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[] ox = br.readLine().toCharArray();

        int bonus = 0;
        int score = 0;
        for (int i = 0; i < N; i++) {
            if (ox[i] == 'O') {
                score += (i + 1 + bonus);
                bonus++;
            } else if (ox[i] == 'X') {
                bonus = 0;
            }
        }
        bw.append((score + bonus) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
