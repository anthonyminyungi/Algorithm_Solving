package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FiveOrSix_2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> AList = new ArrayList<>();
        ArrayList<Integer> BList = new ArrayList<>();

        String[] a = br.readLine().split(" ");
        int A = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);
        char[] forAmax = a[0].toCharArray();
        char[] forAmin = a[0].toCharArray();
        char[] forBmax = a[1].toCharArray();
        char[] forBmin = a[1].toCharArray();

        for (int i = 0; i < a[0].length(); i++) {
            if (forAmax[i] == '5') {
                forAmax[i] = '6';
            }
            if (forAmin[i] == '6') {
                forAmin[i] = '5';
            }
            if (i == a[0].length() - 1) {
                AList.add(Integer.parseInt(String.valueOf(forAmax)));
                AList.add(Integer.parseInt(String.valueOf(forAmin)));
            }
        }
        for (int i = 0; i < a[1].length(); i++) {
            if (forBmax[i] == '5') {
                forBmax[i] = '6';
            }
            if (forBmin[i] == '6') {
                forBmin[i] = '5';
            }

            if (i == a[0].length() - 1) {
                BList.add(Integer.parseInt(String.valueOf(forBmax)));
                BList.add(Integer.parseInt(String.valueOf(forBmin)));
            }
        }
        Collections.sort(AList);
        Collections.sort(BList);
        bw.append((AList.get(0) + BList.get(0)) + " ");
        bw.append((AList.get(AList.size() - 1) + BList.get(BList.size() - 1)) + "");
        bw.flush();
    }
}
