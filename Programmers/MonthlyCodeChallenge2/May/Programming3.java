package com.algorithms.Programmers.MonthlyCodeChallenge2.May;

import java.util.*;

// 시간 내 미제출. 맞는지 확실히는 모르겠으나 생각했던 방법대로 예제는 맞춘듯.
public class Programming3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"1110", "100111100", "0111111010"})));
        //["1101","100110110","0110110111"]
    }

    public static String[] solution(String[] s) {
        int n = s.length;
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(s[i]);
            String target = "";
            while (true) {
                sb.reverse();
                int match = sb.indexOf("011");
                System.out.println(match);
                sb.delete(match, match + 3);
                System.out.println(sb);
                int firstZeroFromMatch = sb.indexOf("0", match + 1);

                System.out.println("lastzero : " + firstZeroFromMatch);
                if (firstZeroFromMatch < 0) sb.insert(sb.length(), "011");
                else sb.insert(firstZeroFromMatch, "011");
                System.out.println(sb);
                sb.reverse();
                if (sb.toString().equals(target)) break;
                target = sb.toString();
            }
            answer[i] = target;
        }
        return answer;
    }
}
