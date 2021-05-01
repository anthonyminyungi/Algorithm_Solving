package com.algorithms.Programmers.Line2021Intern;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("Hello, world!"));
        System.out.println(solution("line [({<plus>)}]"));
        System.out.println(solution("line [({<plus>})"));
        System.out.println(solution(">_<"));
        System.out.println(solution("x * (y + z) ^ 2 = ?\t"));
        System.out.println(solution("ABC)ABC"));
        System.out.println(solution("(A)[B]"));
        System.out.println(solution("ABC({ABC)ABC'"));
    }

    public static int solution(String inputString) {
        int bracketCnt = 0;
        String open = "({[<";
        String close = ")}]>";
        if (close.contains(String.valueOf(inputString.charAt(0)))) return 0;

        Stack<Character> stack = new Stack<>();

        int idx = 0;
        for (char c : inputString.toCharArray()) {
            if (open.contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (close.contains(String.valueOf(c))) {
                    if (stack.isEmpty()) return -idx;
                    else if (open.indexOf(stack.peek()) != close.indexOf(c)) return -idx;
                    else {
                        stack.pop();
                        bracketCnt++;
                    }
                }
            }
            idx++;
        }
        if (!stack.isEmpty()) return -(inputString.length() - 1);
        else return bracketCnt;
    }
}
