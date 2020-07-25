package com.algorithms.Programmers.Practice.Level2;

import java.util.Stack;

public class Level2_RemoveWithPair {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
        System.out.println(solution("abccaeeaba"));
        System.out.println(solution("aaaaaaaaaaaaa"));
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty())
            answer = 1;
        return answer;
    }
}
