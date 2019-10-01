package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] a = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(a[i]));
        }
        Collections.sort(arrayList);
        int res = 0;
        Iterator iterator = arrayList.iterator();
        int e = (int) iterator.next();
        res += e;
        while (iterator.hasNext()) {
            int k = (int) iterator.next();
            res += e + k;
            e += k;
        }
        bw.append(res + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
