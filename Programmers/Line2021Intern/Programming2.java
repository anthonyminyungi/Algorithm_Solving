package com.algorithms.Programmers.Line2021Intern;

import java.util.*;

// 미제출
// 시간 안에 못풀고 다시풀어봄.왜 Stack 생각을 못햇을까...
public class Programming2 {
    static final int INF = 987654321;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 5, 4, 1, 2})));
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[array.length];
        Arrays.fill(answer, INF);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                answer[map.get(stack.peek())] = i;
                stack.pop();
            }
            stack.push(array[i]);
        }
        System.out.println(stack);

        stack.clear();
        stack.push(array[array.length - 1]);
        for (int i = array.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                answer[map.get(stack.peek())] = Math.min(i, map.get(stack.peek()));
                stack.pop();
            }
            stack.push(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (answer[i] == INF) {
                answer[i] = -1;
                break;
            }
        }

        return answer;
    }
}
