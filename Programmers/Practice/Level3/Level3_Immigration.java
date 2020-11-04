package com.algorithms.Programmers.Practice.Level3;

import java.util.*;

// 이분탐색.
// long 타입을 선언할 때 int 타입 변수를 활용하게 되면 명시적 형변환이 필요하다.

public class Level3_Immigration {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 1, max = times[times.length - 1] * n;
        long answer = max;
        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (n > sum) min = mid + 1;
            else {
                if (mid <= answer) answer = mid;
                max = mid - 1;
            }
        }

        return answer;
    }
}
