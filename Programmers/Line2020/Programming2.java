package com.algorithms.Programmers.Line2020;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 2, 5, 1, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{11, 2, 9, 13, 24}, new int[]{9, 2, 13, 24, 11})));
    }

    public static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        Deque<Integer> balls = new LinkedList<>();
        for (int b : ball) {
            balls.add(b);
        }

        int targetIdx = 0;
        List<Integer> pending = new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            if (!balls.isEmpty() && balls.peekFirst() != order[i] && balls.peekLast() != order[i]) {
                pending.add(order[i]);
                continue;
            } else {
                if (!balls.isEmpty() && balls.peekFirst() == order[i]) {
                    answer[targetIdx++] = balls.removeFirst();
                }
                if (!balls.isEmpty() && balls.peekLast() == order[i]) {
                    answer[targetIdx++] = balls.removeLast();
                }
            }
            while (pending.contains(balls.peekFirst()) || pending.contains(balls.peekLast())) {
                if (pending.contains(balls.peekFirst())) {
                    int first = balls.removeFirst();
                    answer[targetIdx++] = first;
                    pending.removeIf(p -> p == first);
                }
                if (pending.contains(balls.peekLast())) {
                    int last = balls.removeLast();
                    answer[targetIdx++] = last;
                    pending.removeIf(p -> p == last);
                }
            }
        }
        return answer;
    }
}
