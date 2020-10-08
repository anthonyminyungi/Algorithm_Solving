package com.algorithms.Programmers.MonthlyCodeChallenge.Oct;

import java.util.*;

// 시험 종료 후 재작성함. 맞는지는 프로그래머스에 문제 나온 뒤 확인해보기

public class Programming4 {
    public static void main(String[] args) {
        System.out.println(solution("baby"));
        System.out.println(solution("oo"));
        System.out.println(solution("baabaa"));
    }

    public static long solution(String s) {
        long answer = 0;
        List<String> substrings = new ArrayList<>();
        String[] split = new String[s.length()];
        int size = 0;
        for (int i = 1; i <= s.length(); i++) {
            size += i;
        }

        for (int j = 0; j < s.length(); j++)
            split[j] = s.substring(j);
        loop:
        for (String sp : split) {
            for (int j = 1; j <= sp.length(); j++) {
                String str1 = sp.substring(0, j);
                if (str1.length() == 1) continue;
                substrings.add(str1);
                if (substrings.size() == size)
                    break loop;
            }
        }

        for (String temp : substrings) {
            int start = 0, end = temp.length() - 1;
            int first = 0, second = 0;
            if (temp.charAt(start) == temp.charAt(end)) {
                while (end > start && temp.charAt(start) == temp.charAt(end)) {
                    end--;
                }
                first = end - start;
                end = temp.length() - 1;
                while (end > start && temp.charAt(start) == temp.charAt(end)) {
                    start++;
                }
                second = end - start;
                answer += Math.max(first, second);
            } else
                answer += end - start;
        }
        return answer;
    }
}
