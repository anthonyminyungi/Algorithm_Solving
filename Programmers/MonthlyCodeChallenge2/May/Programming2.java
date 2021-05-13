package com.algorithms.Programmers.MonthlyCodeChallenge2.May;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(~7);
        System.out.println(Arrays.toString(solution(new long[]{2, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}))); //[3, 11, 9, 10, 11, 13, 13, 14, 15, 23, 17, 18]
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long start = numbers[i];
            if (start % 2 == 0) {
                answer[i] = start + 1;
            } else {
                if (Long.toBinaryString(start).contains("0")) {
                    String bin = Long.toBinaryString(start);
                    int zeroIdx = bin.lastIndexOf("0") + 1;
                    int oneIdx = zeroIdx + 1;
                    answer[i] = start + (long) Math.pow(2, bin.length() - zeroIdx) - (long) Math.pow(2, bin.length() - oneIdx);
                } else {
                    answer[i] = (start / 2) + (long) Math.pow(2, Long.toBinaryString(start).length());
                }
            }
        }

        return answer;
    }
}
