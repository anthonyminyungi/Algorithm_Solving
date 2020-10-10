package com.algorithms.Programmers.Coupang2020;

import java.util.*;

// 제출
public class Programming1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10)));
        System.out.println(Arrays.toString(solution(14)));
    }

    public static int[] solution(int N) {
        int[] answer = new int[2];
        List<K_Pair> list = new ArrayList<>();
        for (int k = 2; k < 10; k++) {
            list.add(new K_Pair(k, charMultiply(Integer.toString(N, k))));
        }
        list.sort(new Comparator<K_Pair>() {
            @Override
            public int compare(K_Pair o1, K_Pair o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        answer[0] = list.get(list.size() - 1).k;
        answer[1] = list.get(list.size() - 1).value;
        return answer;
    }

    private static int charMultiply(String s) {
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                res *= (s.charAt(i) - '0');
        }
        return res;
    }

    static class K_Pair {
        int k;
        int value;

        K_Pair(int k, int value) {
            this.k = k;
            this.value = value;
        }
    }
}
