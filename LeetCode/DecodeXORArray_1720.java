package com.algorithms.LeetCode;

import java.util.*;

public class DecodeXORArray_1720 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(decode(new int[]{6, 2, 7, 3}, 4)));
    }

    public static int[] decode(int[] encoded, int first) {
        // a ^ b = c --> a ^ c = b.
        int n = encoded.length;
        int[] res = new int[n + 1];
        res[0] = first;
        for (int i = 1; i <= n; i++) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }
        return res;
    }
}
