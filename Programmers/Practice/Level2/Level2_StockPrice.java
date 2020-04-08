package com.java.Programmers.Practice.Level2;

import java.util.Arrays;
import java.util.Stack;


// 문제를 제대로 이해를 못해서 풀이를 보고 풀어버렸다. 다시 살펴보기
// https://programmers.co.kr/learn/questions/9454
public class Level2_StockPrice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = prices.length - 2; i >= 0; i--) {
            int day = 0;
            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                day += stack.pop()[1];
            }
            stack.push(new int[]{prices[i], day + 1});
            answer[i] = day + 1;
        }
        return answer;
    }
}
