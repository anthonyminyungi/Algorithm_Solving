package com.algorithms.Programmers.Kakao2020_Solutions;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; ++i) {
            int pos = 0;
            int len = s.length();

            while (pos + i < s.length()) {
                String unit = s.substring(pos, pos + i);
                pos += i;
                int cnt = 0;
                for (; pos + i <= s.length(); ) {
                    if (unit.equals(s.substring(pos, pos + i))) {
                        ++cnt;
                        pos += i;
                    } else break;
                }
                if (cnt > 0) {
                    len -= i * cnt;
                    if (cnt < 9) len += 1;
                    else if (cnt < 99) len += 2;
                    else if (cnt < 999) len += 3;
                    else len += 4;
                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }
}
