package com.algorithms.OnCoder.NHNGodo;

import java.util.*;

// 틀림, Topcoder 문제
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(solution("aaaaabbc", 1));
        System.out.println(solution("aaaabbbbc", 5));
    }

    public static int solution(String s, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) list.add(entry.getValue());
        Collections.sort(list);

        int c1 = list.get(list.size() - 1);
        int c2 = list.get(0);

        int min = c1 - c2;
        for (int i = 1; i <= n; i++) {
            if (c2 == 1) {
                if (min > c1 - list.get(1)) {
                    min = c1 - list.get(1);
                    list.remove(0);
                    if (min == 0) break;
                    continue;
                }
            }
            if (min > Math.abs((c1 - 1) - c2)) {
                min = Math.abs((c1 - 1) - c2);
                list.set(list.size() - 1, list.get(list.size() - 1) - 1);
                if (min == 0) break;
            }
        }

        return min;
    }
}
