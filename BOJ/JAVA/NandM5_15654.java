package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class NandM5_15654 {
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
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];
        perm = new int[m];
        Arrays.sort(arr);
        sb = new StringBuilder();

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
