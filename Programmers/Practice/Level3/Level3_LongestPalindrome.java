package com.algorithms.Programmers.Practice.Level3;

public class Level3_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
        System.out.println(solution("abacde"));
    }

    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (isPalindrome(s, i, j)) {
                    answer = Math.max(j - i + 1, answer);
                    break;
                }
            }
            if (s.length() - 1 - i < answer) break;
        }
        return answer;
    }

    static boolean isPalindrome(String s, int i, int j) {
        int rightIdx = j;
        for (int k = i; k <= (j + i) / 2; k++) {
            if (s.charAt(k) != s.charAt((rightIdx--)))
                return false;
        }

        return true;
    }
}
