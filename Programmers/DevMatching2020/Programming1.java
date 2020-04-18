package com.java.Programmers.DevMatching2020;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution("82195", "64723"));
        System.out.println(solution("00000000000000000000", "91919191919191919191"));
        System.out.println(solution("99999", "11111"));
        System.out.println(solution("22222", "99999"));
    }

    public static int solution(String p, String s) {
        int answer = 0;
        int len = p.length();
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();

        for (int i = 0; i < len; i++) {
            int a = Integer.parseInt(String.valueOf(pc[i]));
            int b = Integer.parseInt(String.valueOf(sc[i]));
            int pos = Math.abs(a - b);
            int neg = 10 - pos;
            answer += Math.min(pos, neg);
        }
        return answer;
    }
}
