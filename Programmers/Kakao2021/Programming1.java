package com.algorithms.Programmers.Kakao2021;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {
        String answer = "";
        char[] specials = "-_.~!@#$%^&*()=+[{]}:?,<>".toCharArray();
        new_id = new_id.toLowerCase(); // 1단계
        for (int i = 0; i < new_id.length(); i++) { // 2단계
            char cur = new_id.charAt(i);
            if (Character.isAlphabetic(cur) || Character.isDigit(cur) || cur == '_' || cur == '-' || cur == '.') {
                answer += cur;
            }
        }
        String dot = ".";
        for (int i = 0; i < 1000; i++) { // 3단계
            dot += ".";

            while (answer.contains(dot)) {
                answer = answer.replace(dot, ".");
            }
        }
        // 4단계
        if (answer.charAt(0) == '.')
            answer = answer.replaceFirst(".", "");

        if (answer.lastIndexOf(".") == answer.length() - 1) {
            if (answer.length() >= 2)
                answer = answer.substring(0, answer.length() - 1);
            else
                answer = answer.replace(".", "");
        }

        // 5단계
        if (answer.isEmpty())
            answer = "a";

        // 6단계
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.lastIndexOf(".") == 14)
                answer = answer.substring(0, 14);
        }

        // 7단계
        if (answer.length() < 3) {
            char last = answer.charAt(answer.length() - 1);
            while (answer.length() < 3)
                answer += last;
        }

        return answer;
    }
}
