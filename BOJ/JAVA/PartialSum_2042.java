package com.algorithms.BOJ.JAVA;

import java.io.*;

public class PartialSum_2042 {
    static long[] tree; // The array that stores segment tree nodes
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        String[] aa = a.split(" ");
        int n = Integer.parseInt(aa[0]);
        int m = Integer.parseInt(aa[1]);
        int l = Integer.parseInt(aa[2]);
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new long[n * 4];
        init(arr, 0, n - 1, 1);

        for (int j = 0; j < m + l; j++) {
            String b = br.readLine();
            String[] bb = b.split(" ");
            int q = Integer.parseInt(bb[0]);
            int w = Integer.parseInt(bb[1]);
            long e = Long.parseLong(bb[2]);
            if (q == 1) {
                long nw = arr[w - 1];
                arr[w - 1] = e;
                update(0, n - 1, 1, w - 1, arr[w - 1] - nw);
            }
            if (q == 2) {
                long sum = sum(0, n - 1, 1, w - 1, e - 1);
                bw.write(sum + "\n");
            }

        }
        bw.flush();
        bw.close();
        // 1 2 3 4 5
        // 1 2 3 / 4 5
        // 1 2 (3) / (4) (5)
        // (1) (2)
    }

    // node를 root로 하는 서브트리를 초기화하고, 이 구간의 최소치를 반환한다
    static long init(long[] arr, int left, int right, int node) {
        if (left == right) {
            return tree[node] = arr[left];
        }
        int mid = (left + right) / 2;
        tree[node] += init(arr, left, mid, node * 2);
        tree[node] += init(arr, mid + 1, right, node * 2 + 1);
        return tree[node];
    }

    static long sum(int start, int end, int node, int left, long right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static void update(int start, int end, int node, int index, long dif) {
        if (index < start || index > end) return;
        tree[node] += dif;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, dif);
        update(mid + 1, end, node * 2 + 1, index, dif);
    }
}

