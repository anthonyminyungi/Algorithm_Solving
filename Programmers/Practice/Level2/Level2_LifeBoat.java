package com.java.Programmers.Practice.Level2;

import java.util.Arrays;

// 더 짧고 좋은 코드가 있겠지만 현재 내 머리로는 이게 최선...

public class Level2_LifeBoat {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
        System.out.println(solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(solution(new int[]{50, 50, 50}, 100));
        System.out.println(solution(new int[]{40, 60, 30, 70}, 100));
        System.out.println(solution(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 100));
        System.out.println(solution(new int[]{10, 10, 10, 30, 70}, 100));
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lastMaxIndex = people.length - 1;
        if (people[0] > limit / 2)
            return people.length;
        for (int i = 0; i < people.length / 2; i++) {
            for (int j = lastMaxIndex; j > i; j--) {
                if (people[j] != -1 && people[i] + people[j] <= limit) {
                    answer++;
                    people[i] = -1;
                    people[j] = -1;
                    lastMaxIndex = j;
                    break;
                }
            }
        }
        for (int i = 0; i < people.length; i++) {
            if (people[i] != -1) {
                answer++;
            }
        }
        return answer;
    }
}
