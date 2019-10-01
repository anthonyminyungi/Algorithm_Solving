package com.java;

import java.io.*;

public class GoodNumberPanel_1871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] a = br.readLine().split("-");
            int front = 26 * 26 * (a[0].charAt(0) - 65) + 26 * (a[0].charAt(1) - 65) + (a[0].charAt(2) - 65);
            int back = Integer.parseInt(a[1]);
            if (Math.abs(front - back) <= 100)
                bw.append("nice\n");
            else
                bw.append("not nice\n");
        }
        bw.flush();
    }
}
