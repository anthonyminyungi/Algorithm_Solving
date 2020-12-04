package com.algorithms.HackerRank.KakaoEnterprise;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<>();
        t1.add(10);
        t1.add(-5);
        t1.add(6);
        System.out.println(splitIntoTwo(t1));
        t1.clear();
        t1.add(-3);
        t1.add(-2);
        t1.add(10);
        t1.add(20);
        t1.add(-30);
        System.out.println(splitIntoTwo(t1));
        t1.clear();
        t1.add(10);
        t1.add(4);
        t1.add(-8);
        t1.add(7);
        System.out.println(splitIntoTwo(t1));
    }

    public static int splitIntoTwo(List<Integer> arr) {
        int ans = 0;
        int leftSum = 0;
        int rightSum = 0;

        leftSum += arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            rightSum += arr.get(i);
        }
        if (leftSum > rightSum)
            ans++;
        for (int i = 1; i < arr.size() - 1; i++) {
            leftSum += arr.get(i);
            rightSum -= arr.get(i);
            if (leftSum > rightSum)
                ans++;
        }

        return ans;
    }
}
