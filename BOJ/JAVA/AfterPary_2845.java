package com.algorithms.BOJ.JAVA;

import java.io.*;

public class AfterPary_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        int people = Integer.parseInt(a[0]) * Integer.parseInt(a[1]);
        for (int i = 0; i < b.length; i++) {
            int temp = Integer.parseInt(b[i]) - people;
            bw.append(temp + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
