package com.java.BOJ.JAVA;

import java.io.*;

public class PartialSum_2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
        int l = Integer.parseInt(aa[2]);
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(nums, n);
        for (int j = 0; j < m + l; j++) {
            String b = br.readLine();
            String[] bb = b.split(" ");
            int q = Integer.parseInt(bb[0]);
            int w = Integer.parseInt(bb[1]);
            long e = Integer.parseInt(bb[2]);
            if (q == 1) {
                long nw = nums[w - 1];
                nums[w - 1] = e;
                segmentTree.update(0, n - 1, 1, w - 1, nums[w - 1] - nw);
            }
            if (q == 2) {
                if (w > e) {
                    bw.write(0 + "\n");
                } else {
                    long sum = segmentTree.sum(0, n - 1, 1, w - 1, e - 1);
                    bw.write(sum + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        // 1 2 3 4 5
        // 1 2 3 / 4 5
        // 1 2 (3) / (4) (5)
        // (1) (2)
    }

    static class SegmentTree {
        long[] segmentArr; // The array that stores segment tree nodes

        SegmentTree(long[] arr, int n) {

            segmentArr = new long[n * 4];
            init(arr, 0, n - 1, 1);
        }

        // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
        long init(long[] arr, int left, int right, int node) {
            if (left == right) {
                return segmentArr[node] = arr[left];
            }
            int mid = (left + right) / 2;
            segmentArr[node] += init(arr, left, mid, node * 2);
            segmentArr[node] += init(arr, mid + 1, right, node * 2 + 1);
            return segmentArr[node];
        }

        long sum(int start, int end, int node, int left, long right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return segmentArr[node];
            int mid = (start + end) / 2;
            return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
        }

        void update(int start, int end, int node, int index, long dif) {
            if (index < start || index > end) return;
            segmentArr[node] += dif;
            if (start == end) return;
            int mid = (start + end) / 2;
            update(start, mid, node * 2, index, dif);
            update(mid + 1, end, node * 2 + 1, index, dif);
        }
    }

}

