package com.java;

import java.io.*;

public class Tenbuje_10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        int day = Integer.parseInt(a);
        String b = br.readLine();
        String[] bb = b.split(" ");
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            int car = Integer.parseInt(bb[i]);
            if (car == day)
                cnt++;
        }
        bw.append("" + cnt);
        bw.flush();
        bw.close();
        br.close();
    }
}
