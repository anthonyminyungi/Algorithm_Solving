package com.algorithms.HackerRank;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        List<Integer> t1 = new ArrayList<>();
        t1.add(1);
        t1.add(2);
        t1.add(3);
        t1.add(1);
        t1.add(2);
        System.out.println(segment(1, t1));
        t1.clear();
        t1.add(1);
        t1.add(1);
        t1.add(1);
        System.out.println(segment(2, t1));
        t1.clear();
        t1.add(2);
        t1.add(5);
        t1.add(4);
        t1.add(6);
        t1.add(8);
        System.out.println(segment(3, t1));
        t1.clear();
        t1.add(8);
        t1.add(2);
        t1.add(4);
        System.out.println(segment(2, t1));
    }

    public static int segment(int x, List<Integer> space) {
        int max = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < space.size(); i++) {
            if (!deque.isEmpty() && deque.getFirst() < i - x + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && space.get(deque.getLast()) > space.get(i))
                deque.pollLast();

            deque.addLast(i);

            if (i >= x - 1 && !deque.isEmpty()) max = Math.max(max, space.get(deque.getFirst()));
        }

        return max;
    }
}
