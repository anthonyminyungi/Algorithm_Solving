package com.algorithms.Programmers.Coupang2020;

import java.util.*;

// 제출
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{24, 22, 20, 10, 5, 3, 2, 1}));
        System.out.println(solution(2, new int[]{1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638, 157658634, 100000000, 100}));
    }

    public static int solution(int k, int[] score) {
        Map<Integer, List<Integer>> diffsMap = new HashMap<>();
        Map<Integer, Integer> diffsCnt = new HashMap<>();
        int p = score[0];
        for (int i = 1; i < score.length; i++) {
            int diff = p - score[i];
            p = score[i];

            if (!diffsMap.containsKey(diff))
                diffsMap.put(diff, new ArrayList<>());
            diffsCnt.put(diff, diffsCnt.getOrDefault(diff, 0) + 1);
            List<Integer> list = diffsMap.get(diff);
            if (!list.contains(i - 1)) list.add(i - 1);
            if (!list.contains(i)) list.add(i);
        }
        System.out.println(diffsMap);
        System.out.println(diffsCnt);

        Set<Integer> fail = new HashSet<>();

        for (int key : diffsCnt.keySet()) {
            if (diffsCnt.get(key) >= k) {
                fail.addAll(diffsMap.get(key));
            }
        }

        return score.length - fail.size();
    }
}
