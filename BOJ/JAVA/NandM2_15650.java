package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class NandM2_15650 {
    static List<int[]> combiList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] res = new int[m];
        for (int i = 1; i <= n; i++) arr[i - 1] = i;
        combiList = new ArrayList<>();

        combi(n, m, 0, 0, arr, res);

        for (int[] c : combiList) {
            for (int i = 0; i < c.length; i++) {
                System.out.print(c[i]);
                if (i != c.length - 1) System.out.print(" ");
                else System.out.print("\n");
            }
        }
    }

    static void combi(int n, int r, int idx, int depth, int[] arr, int[] result) {
        if (depth == r) {
            combiList.add(result.clone());
            return;
        }
        if (idx == n) return;

        result[depth] = arr[idx];

        combi(n, r, idx + 1, depth + 1, arr, result);
        combi(n, r, idx + 1, depth, arr, result);
    }
}
