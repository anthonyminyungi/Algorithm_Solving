package com.java.BOJ.JAVA;

import java.io.*;

public class Sadist_14656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) != Integer.parseInt(a[i]))
                cnt++;
        }
        bw.append(cnt + "");
        bw.flush();
    }
}
