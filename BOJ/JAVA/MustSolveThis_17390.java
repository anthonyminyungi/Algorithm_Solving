package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MustSolveThis_17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        int N = Integer.parseInt(a[0]);
        int Q = Integer.parseInt(a[1]);
        String[] seq = br.readLine().split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < seq.length; i++) {
            arrayList.add(Integer.parseInt(seq[i]));
        }
        Collections.sort(arrayList);
        System.out.println(arrayList);
        int[] subArr = new int[N];
        subArr[0] = arrayList.get(0);

        for (int i = 1; i < N; i++) {
            subArr[i] = arrayList.get(i) + subArr[i - 1];
            System.out.println(subArr[i]);
        }


        for (int i = 0; i < Q; i++) {
            String[] k = br.readLine().split(" ");
            int start = Integer.parseInt(k[0]);
            int end = Integer.parseInt(k[1]);
            if (start > 1) {
                bw.append((subArr[end - 1] - subArr[start - 2]) + "\n");
            } else
                bw.append((subArr[end - 1]) + "\n");
        }
        bw.flush();
    }
}


