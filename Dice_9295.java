package com.java;

import java.io.*;

public class Dice_9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int sum = 0;
            String[] a = br.readLine().split(" ");
            bw.append("Case " + (i + 1) + ": " + (Integer.parseInt(a[0]) + Integer.parseInt(a[1])) + "\n");
        }
        bw.flush();
    }
}
