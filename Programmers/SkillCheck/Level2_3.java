package com.algorithms.Programmers.SkillCheck;

import java.util.Stack;

public class Level2_3 {
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())"));
    }

    public static int solution(String arrangement) {
        int answer = 0;
        char[] arr = arrangement.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                stack.pop();
                if (arr[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
            System.out.println(stack);
        }


        return answer;
    }

}
