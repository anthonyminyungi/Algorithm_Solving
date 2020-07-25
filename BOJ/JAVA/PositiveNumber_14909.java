package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PositiveNumber_14909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        String[] arr = br.readLine().split(" ");
        for (String s : arr) {
            if (Integer.parseInt(s) > 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}
