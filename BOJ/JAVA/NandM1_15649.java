package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class NandM1_15649 {
    static int n, m;
    static int[] arr;
    static int[] perm;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        sb = new StringBuilder();
        perm = new int[m];
        for (int i = 1; i <= n; i++) arr[i - 1] = i;

        permutation(0);
        System.out.println(sb.toString());
    }

    static void permutation(int depth) {
        if (m == depth) {
            for (int i = 0; i < perm.length; i++) {
                sb.append(perm[i]);
                if (i != perm.length - 1) sb.append(" ");
                else sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
