package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class SolvedAC_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int except = (int) Math.round(n * 0.15);
        int[] nani = new int[n];
        for (int i = 0; i < n; i++) {
            nani[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nani);
        int sum = 0;
        int divisor = 0;
        for (int i = except; i < n - except; i++) {
            sum += nani[i];
            divisor++;
        }
        System.out.println((int) Math.round((double) sum / (double) divisor));
    }
}
