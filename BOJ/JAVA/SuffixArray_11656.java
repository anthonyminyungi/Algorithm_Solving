package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SuffixArray_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        char[] b = a.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--) {
            String susb = a.substring(i, a.length());
            arrayList.add(susb);
        }
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            bw.append(arrayList.get(i) + "\n");
        }
        bw.flush();
    }
}
