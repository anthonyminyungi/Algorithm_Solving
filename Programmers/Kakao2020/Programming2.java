package com.algorithms.Programmers.Kakao2020;

import java.util.*;

public class Programming2 {
    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));

    }

    public static long solution(String expression) {
        long answer = 0;
        String[] priority = {"* + -", "* - +", "+ * -", "+ - *", "- * +", "- + *"};
        List<String> operations = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                operations.add(num.toString());
                operations.add(String.valueOf(expression.charAt(i)));
                num = new StringBuilder();
            } else if (i == expression.length() - 1) {
                num.append(expression.charAt(i));
                operations.add(num.toString());
            } else {
                num.append(expression.charAt(i));
            }
        }
        List<Long> prize = new ArrayList<>();

        for (int i = 0; i < priority.length; i++) {
            String[] currentPriority = priority[i].split(" ");
            List<String> copyOfOperations = new LinkedList<>(operations);
            for (int j = 0; j < currentPriority.length; j++) {
                while (copyOfOperations.indexOf(currentPriority[j]) > 0) {
                    int opIndex = copyOfOperations.indexOf(currentPriority[j]);
                    long result = 0;
                    String operator = copyOfOperations.remove(opIndex);
                    String operand2 = copyOfOperations.remove(opIndex);
                    String operand1 = copyOfOperations.remove(opIndex - 1);
                    if (operator.equals("*"))
                        result = Long.parseLong(operand1) * Long.parseLong(operand2);
                    else if (operator.equals("+"))
                        result = Long.parseLong(operand1) + Long.parseLong(operand2);
                    else
                        result = Long.parseLong(operand1) - Long.parseLong(operand2);
                    copyOfOperations.add(opIndex - 1, String.valueOf(result));
                }
            }
            prize.add(Math.abs(Long.parseLong(copyOfOperations.get(0))));
        }
        Collections.sort(prize);
        answer = prize.get(prize.size() - 1);
        return answer;
    }
}

