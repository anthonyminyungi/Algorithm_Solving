package com.algorithms.Programmers.EstSoft;

import java.util.*;

public class Programming1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"3285-3764-9934-2453", "3285376499342453", "3285-3764-99342453", "328537649934245", "3285376499342459", "3285-3764-9934-2452"})));
        System.out.println(check("3285-3764-9934-2453-"));
    }

    public static int[] solution(String[] card_numbers) {
        int[] answer = new int[card_numbers.length];
        for (int i = 0; i < card_numbers.length; i++) {
            answer[i] = check(card_numbers[i]);
        }
        return answer;
    }

    static int check(String cardNumber) {
        if (cardNumber.contains("-")) {
            if (cardNumber.charAt(0) == '-' || cardNumber.charAt(cardNumber.length() - 1) == '-') return 0;
            String[] temp = cardNumber.split("-");
            if (temp.length != 4) return 0;
            for (String t : temp) {
                if (t.length() != 4) return 0;
            }
            cardNumber = cardNumber.replaceAll("-", "");
        }
        if (cardNumber.length() != 16) return 0;
        int sum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            if ((i + 1) % 2 == 0) {
                sum += (cardNumber.charAt(i) - '0');
            } else {
                int temp = (cardNumber.charAt(i) - '0') * 2;
                if (temp >= 10) temp -= 9;
                sum += temp;
            }
        }

        return sum % 10 == 0 ? 1 : 0;
    }
}
