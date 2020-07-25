package com.algorithms.LeetCode;

// Easy
public class ReverseInteger_7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-321));
        System.out.println(reverse(120));
    }

    // Reverse "Integer" 라고 했으면서 입력으로 9646324351 넣는 문제 수준...
    public static int reverse(int x) {
        String res = x < 0 ? new StringBuilder(String.valueOf(Math.abs(x))).append("-").reverse().toString() : new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
        try {
            return Integer.parseInt(res);
        } catch (Exception e) {
            return 0;
        }
    }
}
