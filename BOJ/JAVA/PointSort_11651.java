package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;

public class PointSort_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] xarr = new int[N];
        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            xarr[i] = x;

        }

    }

}
