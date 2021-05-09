package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class NandM4_15652 {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] res = new int[m];
        for (int i = 1; i <= n; i++) arr[i - 1] = i;
        sb = new StringBuilder();

        combi(n, m, 0, 0, arr, res);
        System.out.println(sb.toString());
    }

    static void combi(int n, int r, int idx, int depth, int[] arr, int[] result) {
        if (depth == r) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
                if (i != result.length - 1) sb.append(" ");
                else sb.append("\n");

            }
            return;
        }
        if (idx == n) return;

        result[depth] = arr[idx];

        combi(n, r, idx, depth + 1, arr, result);
        combi(n, r, idx + 1, depth, arr, result);
    }
}
