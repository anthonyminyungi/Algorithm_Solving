package com.algorithms.LeetCode;

import java.util.*;

public class SmallerNumbersThanCurrent_1365 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        int[] answer = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(copy);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] == copy[j]) {
                    answer[i] = j;
                    break;
                }
            }
        }

        return answer;
    }
}
