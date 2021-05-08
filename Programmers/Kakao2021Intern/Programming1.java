package com.algorithms.Programmers.Kakao2021Intern;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

    static int solution(String s) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        String temp = s;
        for (int i = 0; i < 10; i++) {
            if (temp.contains(map.get(i))) {
                temp = temp.replaceAll(map.get(i), String.valueOf(i));
            }
        }

        return (int) Long.parseLong(temp);
    }
}
