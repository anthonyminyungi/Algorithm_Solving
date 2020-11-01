package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// Binary Search
// 원리에 익숙해질 필요 있음.
// 출처 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A7%95%EA%B2%80%EB%8B%A4%EB%A6%AC-Java

public class Level3_StoneBridge {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        long answer = 0;
        Arrays.sort(rocks);
        long left = 0, right = distance, mid = 0;

        while (left <= right) {
            int cnt = 0;
            int current = 0;
            mid = (left + right) / 2;

            for (int rock : rocks) {
                if (rock - current < mid) cnt++;
                else current = rock;
            }
            if (distance - current < mid) cnt++;

            if (cnt <= n) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) answer;
    }
}
