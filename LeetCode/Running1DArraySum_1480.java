package com.java.LeetCode;

import java.util.Arrays;

public class Running1DArraySum_1480 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4}))); // should return [1,3,6,10]
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1}))); // should return [1,2,3,4,5]
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1}))); // should return [3,4,6,16,17]
    }

    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
        return res;
    }
}
