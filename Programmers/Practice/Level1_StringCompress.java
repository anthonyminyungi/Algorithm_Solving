package com.java.Programmers.Practice;

public class Level1_StringCompress {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        if (s.length() == 1)
            return 1;
        int answer = Integer.MAX_VALUE;
        int limit = s.length() / 2;
        int start = 1;
        StringBuilder sb = new StringBuilder();
        while (start <= limit) {
            int count = 1;
            String find = s.substring(0, start);
            int i = start;
            for (; i < (s.length() / start) * start; i += start) {
                String target = s.substring(i, i + start);
                if (!find.equals(target)) {
                    if (count > 1)
                        sb.append(count).append(find);
                    else
                        sb.append(find);
                    count = 1;
                } else
                    count++;

                find = target;
            }
            if (count > 1)
                sb.append(count).append(s.substring(i - start));
            else
                sb.append(s.substring(i - start));
            answer = Math.min(answer, sb.toString().length());
            start++;
            sb = new StringBuilder();
        }

        return answer;
    }
}
