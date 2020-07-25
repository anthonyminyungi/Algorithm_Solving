package com.algorithms.LeetCode;

public class PalindromeNumber_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String in = String.valueOf(x);
        String reversed = (new StringBuffer(in)).reverse().toString();
        if (in.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
}
