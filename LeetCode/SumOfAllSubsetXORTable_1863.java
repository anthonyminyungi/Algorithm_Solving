package com.algorithms.LeetCode;

public class SumOfAllSubsetXORTable_1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }


    // tricky way
    // https://leetcode.com/problems/sum-of-all-subset-xor-totals/discuss/1211177/Simple-trick-oror-4-lines-of-code-oror-Explained!!
    public static int subsetXORSum(int[] nums) {
        int n = nums.length, res = 0;
        for (int num : nums) {
            res |= num;
        }

        return res * (int) Math.pow(2, n - 1);
    }

//    recursive way
//    public static int subsetXORSum(int[] nums) {
//        return recursion(nums, 0, 0);
//    }
//
//    static int recursion(int[] nums, int idx, int cur) {
//        if (idx == nums.length) return cur;
//
//        return recursion(nums, idx + 1, nums[idx] ^ cur) + recursion(nums, idx + 1, cur);
//    }
}
