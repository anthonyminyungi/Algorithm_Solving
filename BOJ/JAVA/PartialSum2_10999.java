package com.java.BOJ.JAVA;

import java.io.*;

//SegmentTree with Lazy Propagation
public class PartialSum2_10999 {
    private static long[] segmentArr; // The array that stores segment tree nodes
    private static long[] lazy;
    private static int H = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
        int l = Integer.parseInt(aa[2]);
        while (H < n) H *= 2;
        segmentArr = new long[H * 2];
        lazy = new long[H * 2];
        long[] nums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Long.parseLong(br.readLine());
            init(i, nums[i], 1, H, 1);
        }
//        System.out.println(Arrays.toString(segmentArr));
        for (int j = 0; j < m + l; j++) {
            String b = br.readLine();
            String[] bb = b.split(" ");
            int q = Integer.parseInt(bb[0]);
            int w = Integer.parseInt(bb[1]);
            int e = Integer.parseInt(bb[2]);
            if (q == 1) {
                long r = Integer.parseInt(bb[3]);
                update(1, H, 1, w, e, r);
//                System.out.println(Arrays.toString(segmentArr));
//                System.out.println("lazy : " + Arrays.toString(lazy));
            }
            if (q == 2) {
                if (w > e) {
                    bw.write(0 + "\n");
                } else {
                    long sum = sum(1, H, 1, w, e);
                    bw.write(sum + "\n");
                }
            }
        }
//        System.out.println(Arrays.toString(segmentArr));
//        System.out.println("lazy : " + Arrays.toString(lazy));
        bw.flush();
        bw.close();
    }


    // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
    private static long init(int index, long val, int start, int end, int node) {
        if (index < start || index > end) return segmentArr[node];
        if (start == end) return segmentArr[node] += val;
        int mid = (start + end) / 2;
        return segmentArr[node] = init(index, val, start, mid, node * 2) + init(index, val, mid + 1, end, node * 2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right) {
        update_lazy(node, start, end);
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return segmentArr[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update_lazy(int node, int start, int end) {
        if (lazy[node] == 0) return;
        segmentArr[node] += (end - start + 1) * lazy[node];

        if (start != end) {
            lazy[node * 2] += lazy[node];
            lazy[node * 2 + 1] += lazy[node];
        }
        lazy[node] = 0;
    }

    private static long update(int start, int end, int node, int left, int right, long dif) {
        update_lazy(node, start, end);
        if (right < start || end < left) return segmentArr[node];
        if (left <= start && end <= right) {
            if (start != end) {
                lazy[node * 2] += dif;
                lazy[node * 2 + 1] += dif;
            }
            return segmentArr[node] += (end - start + 1) * dif;
        }
        int mid = (start + end) / 2;
        return segmentArr[node] = update(start, mid, node * 2, left, right, dif) + update(mid + 1, end, node * 2 + 1, left, right, dif);
    }
}

