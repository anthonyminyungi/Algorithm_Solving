package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

public class Level3_NightShiftIndex {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
        System.out.println(solution(3, new int[]{1, 1}));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        if (Arrays.stream(works).sum() <= n) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int work : works) {
            pq.add(work);
        }

        while (!pq.isEmpty()) {
            int a = pq.poll();
            n -= 1;
            pq.add(a - 1);
            if (n == 0) break;
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}

