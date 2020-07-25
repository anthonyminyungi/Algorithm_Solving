package com.algorithms.Programmers.Practice.Level2;

import java.util.HashMap;
import java.util.Map;

public class Level2_TournamentPredict {
    public static void main(String[] args) {
        System.out.println(solution(8, 3, 7));
        System.out.println(solution(8, 1, 2));
        System.out.println(solution(8, 2, 3));
        System.out.println(solution(8, 4, 7));

    }

    public static int solution(int n, int a, int b) {
        int answer = 1;
        int right = Math.max(a, b);
        int left = Math.min(a, b);
        Map<Integer, Integer> map = new HashMap<>();
        int exp = 1;
        for (int i = 1; i <= n; i++) {
            map.put(i, exp);
            if (i == 2 * exp)
                exp++;
        }
        System.out.println(map);

        while (true) {
            if (right % 2 == 0 && right - left == 1) {
                break;
            }
            left = map.get(left);
            right = map.get(right);
            answer++;
        }
        return answer;
    }
}
