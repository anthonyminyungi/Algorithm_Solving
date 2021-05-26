package com.algorithms.LeetCode;

public class SubtractProductAndSum_1281 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
        System.out.println(subtractProductAndSum(4421));
    }

    public static int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            product *= (str.charAt(i) - '0');
            sum += (str.charAt(i) - '0');
        }
        return product - sum;
    }
}
