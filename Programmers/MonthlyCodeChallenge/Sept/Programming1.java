package com.algorithms.Programmers.MonthlyCodeChallenge.Sept;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }

    public static int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && !list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
