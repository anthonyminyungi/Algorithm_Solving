package com.java.Programmers.Practice;


public class Level1_DartGame {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        char[] c = dartResult.toCharArray();

        int[] currentScore = new int[3];
        int[] star = new int[3];
        boolean[] sharp = new boolean[3];
        int stage = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'S') {
                currentScore[stage] = Integer.parseInt(String.valueOf(c[i - 1]));
                if (c[i - 1] == '0' && i != 1 && c[i - 2] == '1') {
                    currentScore[stage] = 10;
                }
                if (i != c.length - 1 && (c[i + 1] == '*')) {
                    star[stage]++;
                    if (stage != 0) {
                        star[stage - 1]++;
                    }
                }
                if (i != c.length - 1 && (c[i + 1] == '#')) {
                    sharp[stage] = true;
                }
                stage++;
            } else if (c[i] == 'D') {
                currentScore[stage] = (int) Math.pow(Integer.parseInt(String.valueOf(c[i - 1])), 2);
                if (c[i - 1] == '0' && i != 1 && c[i - 2] == '1') {
                    currentScore[stage] = (int) Math.pow(10, 2);
                }
                if (i != c.length - 1 && (c[i + 1] == '*')) {
                    star[stage]++;
                    if (stage != 0) {
                        star[stage - 1]++;
                    }
                }
                if (i != c.length - 1 && (c[i + 1] == '#')) {
                    sharp[stage] = true;
                }
                stage++;
            } else if (c[i] == 'T') {
                currentScore[stage] = (int) Math.pow(Integer.parseInt(String.valueOf(c[i - 1])), 3);
                if (c[i - 1] == '0' && i != 1 && c[i - 2] == '1') {
                    currentScore[stage] = (int) Math.pow(10, 3);
                }
                if (i != c.length - 1 && (c[i + 1] == '*')) {
                    star[stage]++;
                    if (stage != 0) {
                        star[stage - 1]++;
                    }
                }
                if (i != c.length - 1 && (c[i + 1] == '#')) {
                    sharp[stage] = true;
                }
                stage++;
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int score = currentScore[i];
            int mul = star[i] * 2;
            if (mul != 0)
                score *= mul;
            if (sharp[i])
                score *= -1;
            sum += score;
        }
        answer = sum;
        return answer;
    }
}
