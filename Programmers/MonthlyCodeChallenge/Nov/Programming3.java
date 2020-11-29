package com.algorithms.Programmers.MonthlyCodeChallenge.Nov;

import java.util.*;

// 44.4점
// 프로그래머스에 나오면 다시 풀어보기. 너무 어려웡...

// DP문제였음.
// 출처 : https://yabmoons.tistory.com/610
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0}));
        System.out.println(solution(new int[]{5, 2, 3, 3, 5, 3}));
        System.out.println(solution(new int[]{5, 2, 3, 3, 5, 3, 2}));
        System.out.println(solution(new int[]{0, 3, 3, 0, 7, 2, 0, 2, 2, 0}));
    }

    public static int solution(int[] a) {
        int answer = -1;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int k : a) cntMap.put(k, cntMap.getOrDefault(k, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() <= answer) continue;
            int res = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] == a[i + 1]) continue;
                if (a[i] != entry.getKey() && a[i + 1] != entry.getKey()) continue;

                res++;
                i++;
            }
            answer = Math.max(answer, res);
        }

        return answer * 2;
    }
}
