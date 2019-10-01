package com.java.BOJ.JAVA;

import java.io.*;

public class ChangyeongMaul_3028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        int[] ball = {1, 0, 0};
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'A') {
                int temp;
                temp = ball[1];
                ball[1] = ball[0];
                ball[0] = temp;
            } else if (a.charAt(i) == 'B') {
                int temp;
                temp = ball[2];
                ball[2] = ball[1];
                ball[1] = temp;
            } else if (a.charAt(i) == 'C') {
                int temp;
                temp = ball[2];
                ball[2] = ball[0];
                ball[0] = temp;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (ball[i] == 1)
                bw.append((i + 1) + "");
        }
        bw.flush();
    }
}
