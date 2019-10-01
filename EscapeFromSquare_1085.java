package com.java;

import java.io.*;

public class EscapeFromSquare_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int x = Integer.parseInt(a[0]), y = Integer.parseInt(a[1]);
        int w = Integer.parseInt(a[2]), h = Integer.parseInt(a[3]);

        int res = (w - x) < (h - y) ? (w - x) : (h - y);
        int res2 = res < x ? res : x;
        int res3 = res2 < y ? res2 : y;
        bw.append(res3 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
