package com.algorithms.Programmers.Practice.Level2;

public class Level2_FindingPrimeNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j != i && j < nums.length; j++) {
                for (int k = 0; k != i && k != j && k < nums.length; k++) {
                    int a = nums[i] + nums[j] + nums[k];
                    if (isPrime(a))
                        answer++;
                }
            }
        }
        return answer;
    }

    public static boolean isPrime(int k) {
        boolean isPrime = false;
        if (k != 1 && k != 999 && k != 1000) {
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
}
