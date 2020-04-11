package com.java.Programmers.Practice.Level2;

import java.util.Arrays;

public class Level2_Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int b = (brown / 2 + 2);
        int c = red + brown;
        answer[0] = (int) ((b + Math.sqrt(Math.pow(b, 2) - 4 * c)) / 2);
        answer[1] = (int) ((b - Math.sqrt(Math.pow(b, 2) - 4 * c)) / 2);

        return answer;
    }
}
