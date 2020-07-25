package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class Hindeks_12109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            h[i] = Math.min(arr[i], n - i);
        }
        Arrays.sort(h);
        System.out.println(h[n - 1]);
    }
}
