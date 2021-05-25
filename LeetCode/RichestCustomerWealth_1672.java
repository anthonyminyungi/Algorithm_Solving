package com.algorithms.LeetCode;

public class RichestCustomerWealth_1672 {
    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }

    public static int maximumWealth(int[][] accounts) {
        int max = -1;
        int row = accounts.length, col = accounts[0].length;
        int sum;
        for (int[] account : accounts) {
            sum = 0;
            for (int j = 0; j < col; j++) sum += account[j];
            if (max < sum) max = sum;
        }
        return max;
    }
}
