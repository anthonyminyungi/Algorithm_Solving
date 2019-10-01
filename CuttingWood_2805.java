package com.java;

import java.io.*;

public class CuttingWood_2805 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String[] aa = a.split(" ");
        int N = Integer.parseInt(aa[0]);
        long M = Integer.parseInt(aa[1]);

        String b = br.readLine();
        String[] bb = b.split(" ");
        br.close();
        long[] Trees = new long[N];
        for (int i = 0; i < N; i++) {
            Trees[i] = Long.parseLong(bb[i]);
        }
        long res = Binary_Search(Trees, M);
        bw.append(res + "");
        bw.flush();
        bw.close();

    }

    static long Binary_Search(long[] arr, long len) {
        int l = arr.length;
        long result = 0;
        long max = Long.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
        long min = 0;
        for (int i = 0; i < l; i++) {
            max = Math.max(arr[i], max);
//            else if (arr[i] < min)
//                min = arr[i];
        }
//        System.out.println("max : " + max + " / " + "min : " + min);
        long mid = 0;
        while (max > min) {
            long total = 0;
            mid = (max + min) / 2;

            for (int i = 0; i < l; i++) {
                total += Math.max(0, arr[i] - mid);

//                int tempnum = arr[i] - mid;
//                if (tempnum >= 0) {
//                    total += tempnum;
//                }
            }
//            System.out.println(total);
            if (total >= len) {
                min = mid + 1;
                result = min;
//                if (result > mid) {
//                    result = mid;
//                }
            } else {
                max = mid;
                result = max;
            }
        }
        return result - 1;
    }
}
