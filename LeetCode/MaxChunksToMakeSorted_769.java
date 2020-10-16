package com.algorithms.LeetCode;

import java.util.*;

public class MaxChunksToMakeSorted_769 {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(maxChunksToSorted(new int[]{2, 1, 6, 4, 3, 7}));
    }

    public static int maxChunksToSorted(int[] arr) {
        if (arr.length < 2) return arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) stack.push(i);
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
                if (!stack.isEmpty() && j <= stack.peek()) stack.pop();
            }
        }
        return stack.size();
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
