package com.algorithms.Programmers.Practice.Level2;

public class Level2_CorrectBracket {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        int det = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                det += 1;
            else {
                if (det == 0)
                    return false;
                det -= 1;
            }
        }
        return det == 0;
    }
}
