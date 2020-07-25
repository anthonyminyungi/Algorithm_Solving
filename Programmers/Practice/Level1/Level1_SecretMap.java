package com.algorithms.Programmers.Practice.Level1;

import java.util.Arrays;

public class Level1_SecretMap {
    public static void main(String[] args) {
        int n1 = 5, n2 = 6;
        int[] arr1_1 = {9, 20, 28, 18, 11};
        int[] arr2_1 = {30, 1, 21, 17, 28};
        int[] arr1_2 = {46, 33, 33, 22, 31, 50};
        int[] arr2_2 = {27, 56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution(n2, arr1_2, arr2_2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String temp1 = String.format("%" + n + "s", (Integer.toBinaryString(arr1[i])));
            String temp2 = String.format("%" + n + "s", (Integer.toBinaryString(arr2[i])));
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (temp1.charAt(j) == '1' || temp2.charAt(j) == '1')
                    s.append("#");
                else
                    s.append(" ");
            }
            answer[i] = s.toString();
        }
        return answer;
    }
}
