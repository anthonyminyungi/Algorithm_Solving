package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortMaster_17263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");

        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            arrayList.add(Long.parseLong(a[i]));
        }
        Collections.sort(arrayList);
        bw.append(arrayList.get(K - 1) + "");
        bw.flush();
    }
}
