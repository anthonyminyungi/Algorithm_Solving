package com.algorithms.Programmers.LINEFintech;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        // 30, [[1, 10, 20, 6], [2, 12, 20, 8], [3, 20, 30, 2], [4, 25, 40, 10]]
        System.out.println(Arrays.toString(solution(30, new int[][]{{1, 10, 20, 6}, {2, 12, 20, 8}, {3, 20, 30, 2}, {4, 25, 40, 10}})));
        // 40, [[1, 10, 20, 3], [2, 14, 20, 9], [3, 18, 24, 2], [4, 25, 40, 5], [5, 28, 40, 1]]
        System.out.println(Arrays.toString(solution(40, new int[][]{{1, 10, 20, 3}, {2, 14, 20, 9}, {3, 18, 24, 2}, {4, 25, 40, 5}, {5, 28, 40, 1}})));
    }

    public static int[] solution(int endingTime, int[][] jobs) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int currentTime = -1;
        for (int[] job : jobs) {
            if (job[1] <= endingTime && job[2] <= endingTime && (currentTime == -1 ? job[1] : currentTime) + job[3] < job[2]) {
                list.add(job[0]);
            }
            currentTime = job[1] + job[3];
            System.out.println(currentTime);
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
