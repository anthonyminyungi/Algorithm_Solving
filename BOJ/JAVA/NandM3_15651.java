package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 조합/순열 출력하는 문제는 그냥 그때그때 출력하는게 나음.
// 경우의 수가 많을수록 그걸 밖으로 가져나오는게 더 오래걸림.
public class NandM3_15651 {
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
        perm = new int[m];
        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) arr[i - 1] = i;

        duplicatePerm(0);
        System.out.println(sb.toString());
    }

    static void duplicatePerm(int depth) {
        if (m == depth) {
            for (int i = 0; i < perm.length; i++) {
                sb.append(perm[i]);
                if (i != perm.length - 1) sb.append(" ");
                else sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            perm[depth] = arr[i];
            duplicatePerm(depth + 1);
        }
    }
}
