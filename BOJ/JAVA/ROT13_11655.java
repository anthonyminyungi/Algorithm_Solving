package com.algorithms.BOJ.JAVA;

import java.io.*;

public class ROT13_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] in = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : in) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                if (!Character.isUpperCase((char) ((int) c + 13)))
                    sb.append((char) ((int) c - 13));
                else
                    sb.append((char) ((int) c + 13));
            } else if (Character.isLetter(c) && Character.isLowerCase(c)) {
                if (!Character.isLowerCase((char) ((int) c + 13)))
                    sb.append((char) ((int) c - 13));
                else
                    sb.append((char) ((int) c + 13));
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
