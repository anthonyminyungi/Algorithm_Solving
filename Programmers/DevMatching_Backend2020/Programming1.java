package com.algorithms.Programmers.DevMatching_Backend2020;

import java.util.*;

// 100.0
public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"}, 2));
        System.out.println(solution(new String[]{"AAD", "AAA", "AAC", "AAB"}, 4));
    }

    public static String solution(String[] votes, int k) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String v : votes) {
            if (!map.containsKey(v)) {
                map.put(v, 1);
            } else {
                map.put(v, map.getOrDefault(v, 1) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue()))
                    return o2.getValue().compareTo(o1.getValue());
                else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });

        int sumOfTopVotes = 0;
        for (int i = 0; i < k; i++) {
            sumOfTopVotes += entryList.get(i).getValue();
        }
        int sumOfLoseVote = 0;
        while (true) {
            int i = entryList.size() - 1;
            sumOfLoseVote += entryList.get(i).getValue();
            if (sumOfTopVotes <= sumOfLoseVote)
                break;
            answer = entryList.get(i).getKey();
            entryList.remove(i);
        }

        return answer;
    }
}
