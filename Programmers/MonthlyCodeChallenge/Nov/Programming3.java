package com.algorithms.Programmers.MonthlyCodeChallenge.Nov;

import java.util.*;

// 44.4점
// 프로그래머스에 나오면 다시 풀어보기. 너무 어려웡...
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0}));
        System.out.println(solution(new int[]{5, 2, 3, 3, 5, 3}));
        System.out.println(solution(new int[]{5, 2, 3, 3, 5, 3, 2}));
        System.out.println(solution(new int[]{0, 3, 3, 0, 7, 2, 0, 2, 2, 0}));
    }

    public static int solution(int[] a) {
        if (a.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        List<int[]> list;
        int idx = 0;

        while (true) {
            list = new ArrayList<>();
            int k = Integer.MAX_VALUE;
            for (int i = 0; i < a.length - 1; i += 2) {
                if (idx == i) {
                    i--;
                    continue;
                }
                if (list.isEmpty()) {
                    if (a[i] != a[i + 1]) {
                        list.add(new int[]{a[i], a[i + 1]});
                    } else {
                        i--;
                    }
                } else {
                    if (list.size() == 1) {
                        int[] before = list.get(0);
                        if (a[i] != a[i + 1] && (before[0] == a[i] || before[0] == a[i + 1] || before[1] == a[i] || before[1] == a[i + 1])) {
                            list.add(new int[]{a[i], a[i + 1]});
                            if (before[0] == a[i] || before[0] == a[i + 1]) k = before[0];
                            else if (before[1] == a[i] || before[1] == a[i + 1]) k = before[1];
                        } else {
                            i--;
                        }
                    } else {
                        if (a[i] != a[i + 1] && (a[i] == k || a[i + 1] == k)) {
                            list.add(new int[]{a[i], a[i + 1]});
                        } else {
                            i--;
                        }
                    }
                }
            }
            idx++;
            if (list.size() * 2 < max || idx > a.length / 2) break;
            max = list.size() * 2;
        }
        return max;
    }
}
