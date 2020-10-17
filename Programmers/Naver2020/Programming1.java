package com.algorithms.Programmers.Naver2020;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("kkaxbycyz", "abc"));
        System.out.println(solution("acbbcdc", "abc"));
    }

    public static String solution(String m, String k) {
        StringBuilder answer = new StringBuilder();
        int kidx = 0;
        for (int i = 0; i < m.length(); i++) {
            if (kidx != k.length() && m.charAt(i) == k.charAt(kidx)) {
                kidx++;
            } else {
                answer.append(m.charAt(i));
            }
        }
        return answer.toString();
    }
}
