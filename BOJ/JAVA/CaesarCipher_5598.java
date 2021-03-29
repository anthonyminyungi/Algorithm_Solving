package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CaesarCipher_5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            word[i] -= 3;
            if ((int) word[i] < 65) word[i] += 26;
            sb.append(word[i]);
        }
        System.out.println(sb.toString());
    }
}
