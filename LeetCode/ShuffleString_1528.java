package com.algorithms.LeetCode;

public class ShuffleString_1528 {
    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
    }

    public static String restoreString(String s, int[] indices) {
        int len = indices.length;
        char[] shuffle = new char[len];
        for (int i = 0; i < len; i++) {
            shuffle[indices[i]] = s.charAt(i);
        }

        return String.valueOf(shuffle);
    }
}
