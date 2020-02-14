package com.java.Programmers.Practice.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_Printer {
    public static void main(String... args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < priorities.length; i++) {
            Pair pair = new Pair(i, priorities[i]);
            max = Math.max(pair.priority, max);
            queue.add(pair);
        }
        while (!queue.isEmpty()) {
            int find = 0;
            while (true) {
                if (!queue.isEmpty() && queue.peek().priority != max) {
                    queue.add(queue.remove());
                } else {
                    find = queue.remove().index;
                    max = Integer.MIN_VALUE;
                    for (int j = 0; j < queue.size(); j++) {
                        Pair tmp = queue.remove();
                        max = Math.max(max, tmp.priority);
                        queue.add(tmp);
                    }
                    break;
                }
            }
            answer++;
            if (find == location)
                break;
        }
        return answer;
    }
}

class Pair {
    int index;
    int priority;

    Pair(int i, int p) {
        this.index = i;
        this.priority = p;
    }
}