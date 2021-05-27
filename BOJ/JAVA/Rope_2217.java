package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Rope_2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -987654321;
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int length = n;
        for (int i = 0; i < n; i++) {
            if (max < ropes[i] * length) max = ropes[i] * length;
            length--;
        }

        System.out.println(max);
    }
}
