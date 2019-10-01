package com.java;

import java.io.*;

public class Alphabet_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();

        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] cnt = new int[26];
        for (int i = 0; i < a.length; i++) {
            cnt[alpha.indexOf(a[i])]++;
        }
        for (int i = 0; i < 26; i++) {
            bw.append(cnt[i] + " ");
        }
        bw.flush();
    }
}
