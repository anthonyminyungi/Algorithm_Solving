package com.java.BOJ.JAVA;

import java.io.*;

public class PalindromeCheck_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String reversed = (new StringBuffer(a)).reverse().toString();

        if (a.equals(reversed))
            bw.append("1");
        else
            bw.append("0");
        bw.flush();
    }
}
