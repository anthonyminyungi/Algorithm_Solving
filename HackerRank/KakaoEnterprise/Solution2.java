package com.algorithms.HackerRank.KakaoEnterprise;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int[] t = {1, 2, 2, 3, 4, 5, 6, 6, 13, 16};
        int[] p = {10, 15};
        List<Integer> k = new ArrayList<>();
        List<Integer> k2 = new ArrayList<>();
        for (int i : t) {
            k.add(i);
        }
        for (int j : p) {
            k2.add(j);
        }
        System.out.println(requestsServed(k, k2));
        int[] t2 = {2, 2, 4, 8, 11, 28, 30};
        int[] p2 = {0, 5, 5, 15};
        k.clear();
        k2.clear();
        for (int i : t2) {
            k.add(i);
        }
        for (int j : p2) {
            k2.add(j);
        }
        System.out.println(requestsServed(k, k2));
        int[] t3 = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] p3 = {6, 6, 6, 6};
        k.clear();
        k2.clear();
        for (int i : t3) {
            k.add(i);
        }
        for (int j : p3) {
            k2.add(j);
        }
        System.out.println(requestsServed(k, k2));
        int[] t4 = {0, 1, 1, 2, 4, 5};
        int[] p4 = {5};
        k.clear();
        k2.clear();
        for (int i : t4) {
            k.add(i);
        }
        for (int j : p4) {
            k2.add(j);
        }
        System.out.println(requestsServed(k, k2));
    }

    public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
        int ans = timestamp.size();
        Stack<Integer> stack = new Stack<>();
        Collections.sort(timestamp);
        Collections.sort(top);
        stack.addAll(timestamp);

        Stack<Integer> temp = new Stack<>();
        for (int tp : top) {
            while (!stack.isEmpty() && stack.peek() > tp) {
                temp.push(stack.pop());
            }

            for (int i = 0; i < 5; i++) {
                if (!stack.isEmpty() && stack.peek() <= tp) {
                    stack.pop();
                }
            }

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        return ans - stack.size();
    }
}
