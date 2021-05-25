package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class SumOfSubset_1182 {
    static int n, s, cnt;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(cnt);
    }

    static void dfs(int idx, int sum) {
        if (idx >= n) return;

        int temp = sum + arr[idx];
        if (temp == s) cnt++;
        dfs(idx + 1, sum);
        dfs(idx + 1, temp);
    }
}
