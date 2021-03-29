package com.algorithms.Programmers.Practice.Level1;

public class Level1_NewIdRecommendation {
    public static void main(String[] args) {
        System.out.println(solution("\"...!@BaT#*..y.abcdefghijklm\""));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        StringBuilder answer = new StringBuilder();

        boolean lastDot = false;
        for (char ch : new_id.toCharArray()) {
            if (!isValid(ch)) continue;
            if (ch == '.') {
                if (answer.length() == 0 || lastDot) continue;
                lastDot = true;
            } else {
                lastDot = false;
            }
            ch = Character.toLowerCase(ch);
            answer.append(ch);
        }

        if (answer.length() >= 16) answer.setLength(15);

        if (answer.length() == 0) answer.append('a');

        if (answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);

        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        }

        return answer.toString();
    }

    static boolean isValid(char c) {
        if (Character.isLetterOrDigit(c)) return true;
        return c == '-' || c == '_' || c == '.';
    }
}
