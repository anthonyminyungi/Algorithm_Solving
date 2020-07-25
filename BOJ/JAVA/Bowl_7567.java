package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Bowl_7567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] a = br.readLine().toCharArray();

        int count = 0;
        if (a[0] == '(') {
            count += 10;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] == '(' && a[i] == '(') {
                    count += 5;
                } else if (a[i - 1] == ')' && a[i] == ')') {
                    count += 5;
                } else
                    count += 10;
            }
        } else if (a[0] == ')') {
            count += 10;
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] == '(' && a[i] == '(') {
                    count += 5;
                } else if (a[i - 1] == ')' && a[i] == ')') {
                    count += 5;
                } else
                    count += 10;
            }

        }
        System.out.println(count);
    }
}
