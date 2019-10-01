package com.java.BOJ.JAVA;

import java.io.*;

public class TenByTen_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        if (a.length() < 10)
            System.out.println(a);
        else {
            for (int i = 0; i < a.length(); i++) {
                if (i % 10 == 0 && i != 0)
                    System.out.println();
                System.out.print(a.charAt(i));
            }
        }
    }
}
