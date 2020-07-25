package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;

// 인터넷에서 찾은 정답 코드 보고 풀었음.
// 다시 복습해보기.
public class Level2_BiggestNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{0, 0, 70}));
        System.out.println(solution(new int[]{12, 121}));
        System.out.println(solution(new int[]{21, 212}));
        System.out.println(solution(new int[]{0, 0, 0, 0}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{40, 403}));
        System.out.println(solution(new int[]{12, 1213}));
        System.out.println(solution(new int[]{41, 415}));
        System.out.println(solution(new int[]{2, 22, 223}));
    }

    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);

        return sb.toString();
    }
}
