package com.algorithms.LeetCode;

import java.util.Arrays;

public class ShuffleTheArray_1470 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3))); // should return [2,3,5,4,1,7]
        System.out.println(Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4))); // should return [1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(shuffle(new int[]{1, 1, 2, 2}, 2))); // should return [1,2,1,2]
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[idx++];
            } else {
                res[i] = nums[n++];
            }
        }
        return res;
    }
}
