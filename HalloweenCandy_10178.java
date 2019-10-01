package com.java;

import java.io.*;

public class HalloweenCandy_10178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] a = br.readLine().split(" ");
            int candy = Integer.parseInt(a[0]);
            int bro = Integer.parseInt(a[1]);
            bw.append("You get " + (candy / bro) + " piece(s) and your dad gets " + (candy % bro) + " piece(s).\n");
        }
        bw.flush();
    }
}
