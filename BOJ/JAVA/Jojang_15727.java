package com.java.BOJ.JAVA;

import java.io.*;

public class Jojang_15727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int L = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (L > 0) {
            if (L >= 5) {
                L -= 5;
                cnt++;
            } else {
                L = 0;
                cnt++;
            }
        }
        bw.append(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
