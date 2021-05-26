package com.algorithms.LeetCode;

import java.util.*;

public class DecompressRunLengthEncodedList_1313 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 1, 2, 3})));
    }

    public static int[] decompressRLElist(int[] nums) {
        int n = nums.length, size = 0;
        for (int i = 0; i < n / 2; i++) {
            size += nums[2 * i];
        }

        int[] answer = new int[size];
        int idx = 0, freq, val;

        for (int i = 0; i < n / 2; i++) {
            freq = nums[2 * i];
            val = nums[2 * i + 1];
            for (int j = 0; j < freq; j++) {
                answer[idx++] = val;
            }
        }

        return answer;
    }
}
