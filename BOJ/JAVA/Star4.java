package com.java.BOJ.JAVA;

import java.io.*;

public class Star4 {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        int n = Integer.parseInt(a);

        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (i < j)
                    System.out.print("*");
            }
            if (i < n - 1)
                System.out.println();
        }
    }
}