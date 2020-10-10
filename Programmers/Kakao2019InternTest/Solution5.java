package com.algorithms.Programmers.Kakao2019InternTest;

// 이분 탐색

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;

        int front = 0;
        int rear = Integer.MAX_VALUE;
        while (front <= rear) {
            int mid = (front + rear) / 2;

            if (isPossible(mid, stones, k)) {
                answer = mid;
                front = mid + 1;
            } else rear = mid - 1;
        }

        return answer;
    }

    static boolean isPossible(int m, int[] s, int k) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] - (m - 1) <= 0)
                count++;
            else
                count = 0;

            if (count >= k) return false;
        }
        return true;
    }
}
