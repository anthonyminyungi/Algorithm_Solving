package com.java.Programmers.Practice.Level2;

public class Level2_JoyStick {
    public static void main(String[] args) {
        System.out.println(solution("JAZ"));
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
        System.out.println(solution("BBBABBBABBB"));
        System.out.println(solution("AA"));
        System.out.println(solution("AAAAAAAAAA"));
        System.out.println(solution("BBBBAAAAB"));
        System.out.println(solution("ABABAAAAAAABA"));
    }

    public static int solution(String name) {
        // ASCII A=65, Z=90
        int answer = 0;
        for (int i = 0; i < name.length(); i++) {
            int forward = (int) name.charAt(i) - 65;
            int backward = 91 - (int) name.charAt(i);
            answer += Math.min(forward, backward);
        }

        int oneALength = name.length() - 1;
        if (name.indexOf('A') == 1 || name.lastIndexOf('A') == name.length() - 1) {
            oneALength -= 1;
        }

        String subString = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                sb.append('A');
            } else {
                if (sb.length() > 1) {
                    if (subString.length() < sb.length()) {
                        subString = sb.toString();
                    }
                }
                sb = new StringBuilder();
            }
        }
        if (subString.length() < sb.length()) {
            subString = sb.toString();
        }

        int firstIndex = name.indexOf(subString);
        int lastIndex = name.lastIndexOf(subString) + (subString.length() - 1);
        int aStringLength = ((firstIndex - 1) * 2) + ((name.length() - 1) - lastIndex);

        answer = subString.length() > name.substring(0, firstIndex).length() + name.substring(lastIndex + 1).length() ? answer + aStringLength : answer + oneALength;
        if (subString.equals(name))
            answer = 0;

        return answer;
    }
}
