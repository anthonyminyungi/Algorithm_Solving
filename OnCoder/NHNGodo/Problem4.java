package com.algorithms.OnCoder.NHNGodo;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println(solution("21378"));
        System.out.println(solution("31378"));
        System.out.println(solution("11111101"));
        System.out.println(solution("50005"));
        System.out.println(solution("26227174957722514961366"));

    }

    public static String solution(String cardNumber) {
        int sum = 0;
        if (cardNumber.length() % 2 == 1) { // 카드번호의 길이가 홀수일 때
            for (int i = 0; i < cardNumber.length(); i++) {
                if ((i + 1) % 2 == 0) { // 카드 자릿수가 짝수번째일 때
                    int tmp = (cardNumber.charAt(i) - '0') * 2; // 자릿수 곱하기 2
                    if (tmp >= 10)
                        tmp -= 9; // 자릿수별 덧셈을 위해 9를 차감 (ex) 13의 자릿수의 합은 1+3 = 4 = (13-10) + ((13-3)/10) = 13 - 9
                    sum += tmp;
                } else sum += cardNumber.charAt(i) - '0'; // 카드 자릿수가 홀수번째일 때 더해준다.
            }
        } else { // 카드번호의 길이가 짝수일 때
            for (int i = 0; i < cardNumber.length(); i++) {
                if ((i + 1) % 2 == 1) { // 카드 자릿수가 홀수번째일 때
                    int tmp = (cardNumber.charAt(i) - '0') * 2;
                    if (tmp >= 10) tmp -= 9;
                    sum += tmp;
                } else sum += cardNumber.charAt(i) - '0'; // 카드 자릿수가 짝수번째일 때 더해준다.
            }
        }
        if (sum % 10 == 0) return "VALID";
        else return "INVALID";
    }
}
