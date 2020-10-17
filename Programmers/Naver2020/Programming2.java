package com.algorithms.Programmers.Naver2020;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}})));
        System.out.println(Arrays.toString(solution(new int[][]{{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}})));
    }

    public static int[] solution(int[][] blocks) {
        int k = blocks.length;
        int kfac = 0;
        for (int i = 1; i <= k; i++) {
            kfac += i;
        }
        int[] answer = new int[kfac];
        Arrays.fill(answer, Integer.MAX_VALUE);
        int size = 1, idx = 0;
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                answer[idx] = blocks[i][1];
                idx += size;
            } else {
                answer[idx + blocks[i][0]] = blocks[i][1];
                idx += size;
            }
            size++;
        }
        if (blocks[1][0] == 0) {
            answer[2] = answer[0] - answer[1];
        } else {
            answer[1] = answer[0] - answer[2];
        }
        int sum = k + 1;
        while (sum < kfac) {
            int cnt = 0;
            size = 2;
            for (int i = 1; i < answer.length - k; i++) {
                if (cnt == size) {
                    cnt = 0;
                    size++;
                }
                if (answer[i] == Integer.MAX_VALUE) {
                    cnt++;
                    continue;
                }
                if (answer[i + size] == Integer.MAX_VALUE) {
                    if (answer[i + size + 1] != Integer.MAX_VALUE) {
                        answer[i + size] = answer[i] - answer[i + size + 1];
                        sum++;
                    }
                } else if (answer[i + size + 1] == Integer.MAX_VALUE) {
                    if (answer[i + size] != Integer.MAX_VALUE) {
                        answer[i + size + 1] = answer[i] - answer[i + size];
                        sum++;
                    }
                }
                cnt++;
            }
        }
        return answer;
    }
}
