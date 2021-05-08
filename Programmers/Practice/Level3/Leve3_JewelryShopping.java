package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Leve3_JewelryShopping {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XYZ", "XYZ"})));
        System.out.println("-----");
        System.out.println(Arrays.toString(solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
        System.out.println("-----");
    }

    public static int[] solution(String[] gems) {
        Set<String> variation = new HashSet<>(Arrays.asList(gems));
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        int start = 0, idx = 0, min = Integer.MAX_VALUE;

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            q.add(gem);

            while (!q.isEmpty() && map.get(q.peek()) > 1) {
                String remove = q.poll();
                map.put(remove, map.get(remove) - 1);
                idx++;
            }

            if (map.size() == variation.size() && min > q.size()) {
                min = q.size();
                start = idx;
            }
        }

        return new int[]{start + 1, start + min};
    }
}
