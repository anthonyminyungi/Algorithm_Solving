package com.java.Programmers.Practice.Level2;

public class Level2_HighestLowest {
    public static void main(String[] args) {
        System.out.println(solution("1 2 3 4"));
        System.out.println(solution("-1 -2 -3 -4"));
        System.out.println(solution("1 -1"));
    }

    public static String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            int a = Integer.parseInt(str[i]);
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        answer = min + " " + max;
        return answer;
    }
}
