package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Level2_Spicier {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScov = first + (2 * second);
            pq.add(newScov);
            answer++;
        }
        if (pq.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
