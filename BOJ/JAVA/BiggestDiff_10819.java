package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class BiggestDiff_10819 {
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        list = new ArrayList<>();
        permutation(arr, 0);
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    public static void permutation(int[] arr, int start) {
        int length = arr.length;
        if (start == length - 1) {
            list.add(getDiff(arr));
            System.out.println(Arrays.toString(arr) + getDiff(arr) + "\n");
            return;
        }

        for (int i = start; i < length; i++) {
            swap(arr, start, i);
            permutation(arr, start + 1);
            swap(arr, start, i);
        }
    }

    public static int getDiff(int[] arr) {
        int diffSum = 0;
        for (int i = 1; i < arr.length; i++) {
            diffSum += Math.abs(arr[i] - arr[i - 1]);
        }
        return diffSum;
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
