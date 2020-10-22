package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class DoublePriorityQueue_Level3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I 7", "I 5", "I -5", "D -1"})));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for (String q : operations) {
            String[] a = q.split(" ");
            if (a[0].equals("I")) {
                maxPq.add(Integer.parseInt(a[1]));
                minPq.add(Integer.parseInt(a[1]));
            } else {
                if (!maxPq.isEmpty() && !minPq.isEmpty()) {
                    if (a[1].equals("1")) {
                        int max = maxPq.poll();
                        minPq.remove(max);
                    } else {
                        int min = minPq.poll();
                        maxPq.remove(min);
                    }
                }
            }
        }

        if (maxPq.isEmpty() && minPq.isEmpty())
            return new int[]{0, 0};
        else
            return new int[]{maxPq.poll(), minPq.poll()};
    }
}
