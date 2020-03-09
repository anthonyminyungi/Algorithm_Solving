package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelfDuplicateNumber_2028 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            int n = Integer.parseInt(s);
            String d = String.valueOf((int) Math.pow(n, 2));
            if (d.substring(d.length() - s.length()).equals(s))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
