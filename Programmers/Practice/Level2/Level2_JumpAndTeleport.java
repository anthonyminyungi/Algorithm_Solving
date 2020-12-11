package com.algorithms.Programmers.Practice.Level2;

public class Level2_JumpAndTeleport {
    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
    }

    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
