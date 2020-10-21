package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// Segment Tree
public class MinimumValue_10868 {
    static long[] segmentArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        segmentArr = new long[n * 4];
        Arrays.fill(segmentArr, Long.MAX_VALUE);
        init(numbers, 0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int a = Integer.parseInt(range[0]);
            int b = Integer.parseInt(range[1]);
            bw.append(String.valueOf(min(0, n - 1, 1, a - 1, b - 1))).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long init(long[] arr, int left, int right, int node) {
        if (left == right) {
            return segmentArr[node] = arr[left];
        }
        int mid = (left + right) / 2;
        segmentArr[node] = Math.min(init(arr, left, mid, node * 2), init(arr, mid + 1, right, node * 2 + 1));
        return segmentArr[node];
    }

    static long min(int start, int end, int node, int left, long right) {
        if (left > end || right < start) return Long.MAX_VALUE;
        if (left <= start && end <= right) return segmentArr[node];

        int mid = (start + end) / 2;
        return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
    }
}
