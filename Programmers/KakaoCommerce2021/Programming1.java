package com.algorithms.Programmers.KakaoCommerce2021;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 5, 3, 2, 1}, new int[]{2, 4, 4, 5, 1}));
        System.out.println(solution(new int[]{5, 4, 5, 4, 5}, new int[]{1, 2, 3, 5, 4}));
    }

    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        Map<Integer, Integer> cardMap = new HashMap<>();
        for (int card : gift_cards) {
            cardMap.put(card, cardMap.getOrDefault(card, 0) + 1);
        }

        for (int want : wants) {
            if (!cardMap.containsKey(want) || cardMap.get(want) == 0) answer++;
            else {
                cardMap.put(want, cardMap.get(want) - 1);
            }
        }
        return answer;
    }
}
