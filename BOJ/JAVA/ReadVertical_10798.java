package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ReadVertical_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLen = 0;
        String[] temp = new String[5];
        for (int i = 0; i < 5; i++) {
            temp[i] = br.readLine();
            maxLen = Math.max(maxLen, temp[i].length());
        }
        char[][] words = new char[5][maxLen];
        for (int i = 0; i < 5; i++) {
            char[] s = temp[i].toCharArray();
            System.arraycopy(s, 0, words[i], 0, s.length);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words[0].length; i++) {
            for (int j = 0; j < 5; j++) {
                if ((int) words[j][i] != 0) {
                    sb.append(words[j][i]);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
