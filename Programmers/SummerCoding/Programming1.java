package com.algorithms.Programmers.SummerCoding;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(solution(1987));
        System.out.println(solution(2015));
    }

    public static int solution(int p) {
        int answer = 0;
        int a = p;
        while (true) {
            a++;
            boolean isNotBeautiful = false;
            char[] c = String.valueOf(a).toCharArray();
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c.length; j++) {
                    if (c[i] == c[j] && i != j) {
                        isNotBeautiful = true;
                        break;
                    }
                }
                if (isNotBeautiful)
                    break;
            }
            if (!isNotBeautiful) {
                answer = Integer.parseInt(String.valueOf(c));
                break;
            }
        }
        return answer;
    }
}
