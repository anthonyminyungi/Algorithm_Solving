package com.algorithms.Programmers.Kakao2020Intern;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right").equals("LRLLLRLLRRL"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left").equals("LRLLRRLLLRR"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right").equals("LLRLLRLLRL"));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int currentRight = 11; //  '*' = 11
        int currentLeft = 12; // '#' = 12
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {11, 0, 12}};
        Map<Integer, int[]> map = new LinkedHashMap<>();
        for (int k = 0; k <= 12; k++) {
            for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[0].length; j++) {
                    if (k == keypad[i][j]) {
                        map.put(k, new int[]{i, j});
                    }
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                currentLeft = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                currentRight = numbers[i];
            } else {
                int[] currentPosition = map.get(numbers[i]);
                int[] prevLeftPosition = map.get(currentLeft);
                int[] prevRightPosition = map.get(currentRight);
                int leftDistance = Math.abs(currentPosition[0] - prevLeftPosition[0]) + Math.abs(currentPosition[1] - prevLeftPosition[1]);
                int rightDistance = Math.abs(currentPosition[0] - prevRightPosition[0]) + Math.abs(currentPosition[1] - prevRightPosition[1]);
                if (leftDistance > rightDistance) {
                    currentRight = numbers[i];
                    answer.append("R");
                } else if (leftDistance < rightDistance) {
                    currentLeft = numbers[i];
                    answer.append("L");
                } else {
                    if (hand.equals("right")) {
                        answer.append("R");
                        currentRight = numbers[i];
                    } else {
                        answer.append("L");
                        currentLeft = numbers[i];
                    }
                }
            }
        }
        return answer.toString();
    }
}
