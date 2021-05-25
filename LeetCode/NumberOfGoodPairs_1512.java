package com.algorithms.LeetCode;

public class NumberOfGoodPairs_1512 {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));
    }

    public static int numIdenticalPairs(int[] nums) {
        int answer = 0, len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) answer++;
            }
        }
        return answer;
    }
}
