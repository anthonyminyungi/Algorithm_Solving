package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class RightTriangle_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while (!(input = br.readLine()).equals("0 0 0")) {
            String[] s = input.split(" ");
            int[] arr = new int[3];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2))
                bw.append("right\n");
            else
                bw.append("wrong\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
