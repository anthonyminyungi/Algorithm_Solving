package com.algorithms.Programmers.MonthlyCodeChallenge.Nov;

import java.util.*;

// 100.0
public class Programming2 {
    static int cnt;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
    }

    public static int[] solution(String s) {
        cnt = 0;

        int idx = 0;
        while (!s.equals("1")) {
            s = binTrans(s);
            idx++;
        }

        return new int[]{idx, cnt};
    }

    public static String binTrans(String x) {
        int c = x.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++) {
            if (x.charAt(i) == '1') sb.append(x.charAt(i));
            else cnt++;
        }

        x = sb.toString();
        c = x.length();

        return Integer.toBinaryString(c);
    }
}
