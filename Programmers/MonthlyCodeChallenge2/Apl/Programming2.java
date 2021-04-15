package com.algorithms.Programmers.MonthlyCodeChallenge2.Apl;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) answer++;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    public static boolean isCorrect(String s) {
        char[] arr = s.toCharArray();
        Set<Character> chs = new HashSet<>();
        for (char c : arr) chs.add(c);
        if (chs.size() % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
                cnt++;
            } else {
                if (!stack.isEmpty() && map.get(arr[i]) == stack.peek()) {
                    stack.pop();
                    cnt--;
                }
            }
        }
        return cnt == 0 && stack.isEmpty();
    }
}
