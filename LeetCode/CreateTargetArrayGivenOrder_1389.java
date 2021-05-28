package com.algorithms.LeetCode;

import java.util.*;

public class CreateTargetArrayGivenOrder_1389 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
        System.out.println(Arrays.toString(createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0})));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < len; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
