package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// Segment Tree
public class PartialMultiply_11505 {
    final static long MOD = 1000000007;
    static long[] segmentArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
        int k = Integer.parseInt(aa[2]);
        long[] nums = new long[n];
        segmentArr = new long[n * 4];
        Arrays.fill(segmentArr, 1);
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        init(nums, 0, n - 1, 1);

        for (int j = 0; j < m + k; j++) {
            String b = br.readLine();
            String[] bb = b.split(" ");
            int q = Integer.parseInt(bb[0]);
            int w = Integer.parseInt(bb[1]);
            long e = Integer.parseInt(bb[2]);
            if (q == 1) {
                nums[w - 1] = e;
                update(0, n - 1, 1, w - 1, e);
            }
            if (q == 2) {
                if (w > e) {
                    bw.write(0 + "\n");
                } else {
                    long mul = mul(0, n - 1, 1, w - 1, e - 1);
                    bw.write(mul + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }

    static long init(long[] arr, int left, int right, int node) {
        if (left == right) {
            return segmentArr[node] = arr[left];
        }
        int mid = (left + right) / 2;

        return segmentArr[node] = (init(arr, left, mid, node * 2) * init(arr, mid + 1, right, node * 2 + 1)) % MOD;
    }

    static long mul(int start, int end, int node, int left, long right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return segmentArr[node];
        int mid = (start + end) / 2;
        return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    static long update(int start, int end, int node, int index, long change) {
        if (index < start || index > end) return segmentArr[node];

        if (start == end) return segmentArr[node] = change;
        int mid = (start + end) / 2;

        return segmentArr[node] = (update(start, mid, node * 2, index, change) * update(mid + 1, end, node * 2 + 1, index, change)) % MOD;
    }
}
