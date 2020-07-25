package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascending_14910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean asc = true;
        String[] in = br.readLine().split(" ");
        int standard = Integer.MIN_VALUE;
        for (String s : in) {
            int cur = Integer.parseInt(s);
            if (cur >= standard)
                standard = cur;
            else {
                asc = false;
                break;
            }
        }
        System.out.println(asc ? "Good" : "Bad");
    }
}
