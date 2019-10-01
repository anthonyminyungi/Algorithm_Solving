package com.java;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MultiMax_14753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(a[i]));
        }
        Collections.sort(arrayList);
        Object[] tem = arrayList.toArray();
        int max = 0;
        int l = tem.length;
        int a1 = ((int) tem[l - 1] * (int) tem[l - 2]);
        int a2 = ((int) tem[0] * (int) tem[1]);
        int a3 = a1 * (int) tem[l - 3];
        int a4 = a1 * (int) tem[0];
        int a5 = a2 * (int) tem[2];
        int a6 = a2 * (int) tem[l - 1];
        int a7 = ((int) tem[l - 1] * (int) tem[0]);
        int a8 = a7 * (int) tem[l - 2];
        int a9 = a7 * (int) tem[1];
        max = Math.max(a1, a2);
        max = Math.max(max, a3);
        max = Math.max(max, a4);
        max = Math.max(max, a5);
        max = Math.max(max, a6);
        max = Math.max(max, a7);
        max = Math.max(max, a8);
        max = Math.max(max, a9);

        bw.append(max + "");
        bw.flush();
    }
}
