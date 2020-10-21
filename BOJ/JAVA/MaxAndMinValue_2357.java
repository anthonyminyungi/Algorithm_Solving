package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// Segment Tree
public class MaxAndMinValue_2357 {
    static long[] minSegmentArr;
    static long[] maxSegmentArr;

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
        minSegmentArr = new long[n * 4];
        maxSegmentArr = new long[n * 4];
        Arrays.fill(minSegmentArr, Long.MAX_VALUE);
        Arrays.fill(maxSegmentArr, Long.MIN_VALUE);
        minInit(numbers, 0, n - 1, 1);
        maxInit(numbers, 0, n - 1, 1);
        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int a = Integer.parseInt(range[0]);
            int b = Integer.parseInt(range[1]);
            long min = min(0, n - 1, 1, a - 1, b - 1);
            long max = max(0, n - 1, 1, a - 1, b - 1);
            bw.append(String.valueOf(min)).append(" ").append(String.valueOf(max)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long minInit(long[] arr, int left, int right, int node) {
        if (left == right) {
            return minSegmentArr[node] = arr[left];
        }
        int mid = (left + right) / 2;
        minSegmentArr[node] = Math.min(minInit(arr, left, mid, node * 2), minInit(arr, mid + 1, right, node * 2 + 1));
        return minSegmentArr[node];
    }

    static long min(int start, int end, int node, int left, long right) {
        if (left > end || right < start) return Long.MAX_VALUE;
        if (left <= start && end <= right) return minSegmentArr[node];

        int mid = (start + end) / 2;
        return Math.min(min(start, mid, node * 2, left, right), min(mid + 1, end, node * 2 + 1, left, right));
    }

    static long maxInit(long[] arr, int left, int right, int node) {
        if (left == right) {
            return maxSegmentArr[node] = arr[left];
        }
        int mid = (left + right) / 2;
        maxSegmentArr[node] = Math.max(maxInit(arr, left, mid, node * 2), maxInit(arr, mid + 1, right, node * 2 + 1));
        return maxSegmentArr[node];
    }

    static long max(int start, int end, int node, int left, long right) {
        if (left > end || right < start) return Long.MIN_VALUE;
        if (left <= start && end <= right) return maxSegmentArr[node];

        int mid = (start + end) / 2;
        return Math.max(max(start, mid, node * 2, left, right), max(mid + 1, end, node * 2 + 1, left, right));
    }
}
