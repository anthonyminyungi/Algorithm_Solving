package com.java.Programmers.Practice.Level2;

public class Level2_OneTwoFour {
    static String[] help = {"", "1", "2", "4", "11", "12", "14", "21", "22", "24", "41", "42", "44"};

    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            System.out.println(i + " : " + solution(i));
        }
    }

    public static String solution(int n) {
        String answer = "";
        if (n < 13)
            return help[n];
        answer = sub(n);
        return answer;
    }

    public static String sub(int n) {
        if (n > 3) {
            if (n % 3 == 0)
                return sub((n - 1) / 3) + "4";
            return sub(n / 3) + help[n % 3];
        } else
            return help[n];
    }
}
