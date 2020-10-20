package com.algorithms.Programmers.Line2020;

import java.util.*;

// 구현 포기. 문제가 너무 까다롭다.
public class Programming5 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{12, 7, 11, 6, 2, 12}));
        System.out.println(solution(new int[]{1, 4, 10, 6, 9, 1, 8, 13}));
        System.out.println(solution(new int[]{10, 13, 10, 1, 2, 3, 4, 5, 6, 2}));
        System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3}));
    }

    public static int solution(int[] cards) {
        int answer = 0;

        List<Integer> player = new ArrayList<>();
        List<Integer> dealer = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {

        }
        return answer;
    }
//
//    static boolean playerGetMoreCard(List<Integer> player, List<Integer> dealer) {
//
//    }

    static int sum(List<Integer> list) {
        int sum = 0;
        for (int item : list)
            sum += item;
        return sum;
    }
}
