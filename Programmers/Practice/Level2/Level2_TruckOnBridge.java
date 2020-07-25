package com.algorithms.Programmers.Practice.Level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_TruckOnBridge {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> pending = new LinkedList<>();
        Queue<int[]> going = new LinkedList<>();
        List<Integer> complete = new LinkedList<>();
        int capacity = 0;
        int time = 1;
        for (int truck_weight : truck_weights) {
            pending.add(truck_weight);
        }

        while (truck_weights.length != complete.size()) {
            if (!pending.isEmpty() && (capacity + pending.peek()) <= weight) {
                int curWeight = pending.poll();
                going.add(new int[]{curWeight, time});
                capacity += curWeight;
            }
            time++;
            if (!going.isEmpty() && going.peek()[1] == time - bridge_length) {
                int[] completed = going.poll();
                complete.add(completed[0]);
                capacity -= completed[0];
            }

        }
        answer = time;
        return answer;
    }
}
