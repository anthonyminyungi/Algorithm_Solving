package com.java.Programmers.Practice.Level2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Level2_PhoneNumberList {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));

    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (String a : phone_book) {
            for (int j = 0; j < a.length(); j++) {
                String b = a.substring(0, j);
                if (map.containsKey(b)) {
                    answer = false;
                    break;
                }
                if (!answer)
                    break;
            }
        }
        return answer;
    }
}
