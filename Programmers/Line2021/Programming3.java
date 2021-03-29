package com.algorithms.Programmers.Line2021;

import java.util.*;

public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
    }

    public static int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        boolean[][] encounter = new boolean[n + 1][n + 1];
        List<Integer> room = new LinkedList<>();

        int e_idx = 0, l_idx = 0;
        while (e_idx < n || l_idx < n) {
            e_idx++;
            if (room.size() > 1) {
                for (int i = 0; i < room.size(); i++) {
                    for (int j = 0; j < room.size(); j++) {
                        if (i != j && !encounter[room.get(i)][room.get(j)])
                            encounter[room.get(i)][room.get(j)] = encounter[room.get(j)][room.get(i)] = true;
                    }
                }
            }

            System.out.println(room + " " + leave[l_idx]);

            if (l_idx < n && room.contains(leave[l_idx])) {
                room.remove((Integer) leave[l_idx]);

                e_idx++;
            } else {
                if (e_idx < n)
                    room.add(enter[e_idx]);
                l_idx++;
            }
        }
        int[] answer = new int[n];

        for (int i = 1; i < encounter.length; i++) {
            int cnt = 0;
            for (int j = 1; j < encounter.length; j++) {
                System.out.println(Arrays.toString(encounter[j]));
                if (encounter[i][j]) cnt++;
            }
            System.out.println();
            answer[i - 1] = cnt;
        }

        return answer;
    }
}
