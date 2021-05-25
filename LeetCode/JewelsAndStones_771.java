package com.algorithms.LeetCode;

import java.util.*;

public class JewelsAndStones_771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int jLen = jewels.length(), sLen = stones.length(), answer = 0;
        for (int i = 0; i < jLen; i++)
            set.add(jewels.charAt(i));
        for (int i = 0; i < sLen; i++)
            if (set.contains(stones.charAt(i))) answer++;
        return answer;
    }
}
