package com.algorithms.BOJ.JAVA;

import java.io.*;

public class NumOfVowel_10987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String vowel = "aeiou";
        char[] in = br.readLine().toCharArray();

        int cnt = 0;
        for (int i = 0; i < in.length; i++) {
            if (vowel.contains("" + in[i])) {
                cnt++;
            }
        }
        bw.append(cnt + "");
        bw.flush();
    }
}
