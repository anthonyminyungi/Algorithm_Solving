package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ThreeNumSort_2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] q = br.readLine().split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.parseInt(q[0]));
        arrayList.add(Integer.parseInt(q[1]));
        arrayList.add(Integer.parseInt(q[2]));
        Collections.sort(arrayList);
        bw.append(arrayList.get(0) + " ");
        bw.append(arrayList.get(1) + " ");
        bw.append(arrayList.get(2) + "");
        bw.flush();
    }
}
