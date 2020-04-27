package com.java.Programmers.Practice.Level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_FindPrime {
    static List<Integer> list;

    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        list = new ArrayList<>();
        int[] intArr = new int[numbers.length()];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        for (int r = 1; r <= numbers.length(); r++) {
            permutation(intArr, 0, numbers.length(), r);
        }
        answer = list.size();
        return answer;
    }

    public static boolean isPrime(int k) {
        boolean isPrime = false;
        if (k > 0 && k != 1) {
            isPrime = true;

            for (int j = 2; j < k; j++) {
                if (k % j == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            int res = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(arr[i]);
            }
            res = Integer.parseInt(sb.toString());
            if (isPrime(res) && !list.contains(res)) list.add(res);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
