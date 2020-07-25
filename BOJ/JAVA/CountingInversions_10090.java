package com.algorithms.BOJ.JAVA;

import java.io.*;

//Counting - Inversions 알고리즘 과제 !!!
//코드 베꼈으니까 다시 보기
public class CountingInversions_10090 {
    static int inversioncnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(a[i]);
        }
        SortAndCount(k, new int[n], 0, n - 1);
        bw.write(inversioncnt + "");
        bw.flush();

    }

    static void SortAndCount(int[] arr, int[] tempArr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            SortAndCount(arr, tempArr, l, m);
            SortAndCount(arr, tempArr, m + 1, r);
            MergeAndCount(arr, tempArr, l, m + 1, r);
        }
    }

    static void MergeAndCount(int[] arr, int[] tempArr, int l, int r, int maxR) {
        int maxL = r - 1;
        int nowsize = maxR - l + 1;
        int tempindex = l;
        int inversions = r;

        while (l <= maxL && r <= maxR) {
            if (arr[l] <= arr[r])
                tempArr[tempindex++] = arr[l++];
            else {
                inversioncnt += inversions - l;
                tempArr[tempindex++] = arr[r++];
            }
        }
        while (l <= maxL)
            tempArr[tempindex++] = arr[l++];
        while (r <= maxR)
            tempArr[tempindex++] = arr[r++];

        for (int i = 0; i < nowsize; i++) {
            arr[maxR] = tempArr[maxR--];
        }

    }
}
