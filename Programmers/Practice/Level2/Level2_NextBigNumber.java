package com.algorithms.Programmers.Practice.Level2;

public class Level2_NextBigNumber {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        String bin = Integer.toBinaryString(n).replaceAll("0", "");
        int answer = n + 1;
        String a = "";
        while (true) {
            a = Integer.toBinaryString(answer).replaceAll("0", "");
            if (a.equals(bin)) break;
            else answer += 1;
        }
        return answer;
    }
}
