package com.algorithms.BOJ.JAVA;

import java.io.*;

public class PalindromeNumber_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in;
        while (!(in = br.readLine()).equals("0")) {
            boolean isPalindrome = true;
            int len = in.length();
            for (int i = 0; i <= len / 2; i++) {
                System.out.println(in.charAt(i) + ", " + in.charAt(len - 1 - i));
                if (in.charAt(i) != in.charAt(len - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome)
                bw.append("no\n");
            else
                bw.append("yes\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
