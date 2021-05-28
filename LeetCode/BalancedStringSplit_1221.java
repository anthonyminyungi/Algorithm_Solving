package com.algorithms.LeetCode;

public class BalancedStringSplit_1221 {
    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        char current = s.charAt(0);
        int currentCnt = 1, length = s.length(), answer = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == current) {
                currentCnt++;
            } else {
                if (currentCnt != 0) {
                    currentCnt--;
                    if (currentCnt == 0) answer++;
                } else {
                    current = s.charAt(i);
                    currentCnt = 1;
                }
            }
        }

        return answer;
    }
}

