package com.algorithms.Programmers.Practice.Level2;

import java.util.Arrays;
import java.util.Stack;

public class Level2_Tower {
    public static void main(String[] args) {
        int[] arr1 = {6, 9, 5, 7, 4};
        System.out.println(Arrays.toString(solution(arr1)));
        int[] arr2 = {3, 9, 9, 3, 5, 7, 2};
        System.out.println(Arrays.toString(solution(arr2)));
        int[] arr3 = {1, 5, 3, 6, 7, 6, 5};
        System.out.println(Arrays.toString(solution(arr3)));
        int[] arr4 = {6, 4, 5, 2, 5, 1};
        System.out.println(Arrays.toString(solution(arr4)));
    }

    public static int[] solution(int[] heights) {
        int N = heights.length;
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.push(heights[i]);
        }
        int k = N - 1;
        int idx = N - 1;
        int tmp = 0;
        boolean isFail = false;
        while (!stack.isEmpty()) {
            if (!isFail) {
                tmp = stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() >= tmp) {
                answer[idx] = k;
                while (!stack1.isEmpty()) {
                    stack.push(stack1.pop());
                    k++;
                }
                idx--;
                isFail = false;
            } else {
                isFail = true;
                if (!stack.isEmpty())
                    stack1.push(stack.pop());
            }
//            System.out.println(stack1);
//            System.out.println(stack);
//            System.out.println(k);
//            System.out.println(idx);
            if (stack.isEmpty()) {
                answer[idx] = 0;
                idx--;
                k--;
                isFail = false;
                while (!stack1.isEmpty()) {
                    stack.push(stack1.pop());
                    k++;
                }
            }
            k--;
        }
        return answer;
    }
}
