package com.algorithms.Programmers.Line2020;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}}));
        System.out.println(solution(new int[][]{{1, 2}, {3, 4}, {5, 6}}));
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {3, 1}}));
    }

    public static int solution(int[][] boxes) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = boxes.length;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i][0] == boxes[i][1]) {
                k--;
                continue;
            } else {
                for (int j = 0; j < 2; j++) {
                    if (!map.containsKey(boxes[i][j])) {
                        map.put(boxes[i][j], 1);
                    } else {
                        map.remove(boxes[i][j]);
                        k--;
                    }
                }
            }
        }

        return k;
    }
}
