package com.algorithms.Programmers.Practice.Level2;

public class Level2_JadenCaseString {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                if (Character.isLetter(s.charAt(i))) {
                    answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                } else {
                    answer.append(s.charAt(i));
                }
            } else {
                if (Character.isLetter(s.charAt(i))) {
                    answer.append(String.valueOf(s.charAt(i)).toLowerCase());
                } else {
                    answer.append(s.charAt(i));
                }
            }
        }
        return answer.toString();
    }
}
