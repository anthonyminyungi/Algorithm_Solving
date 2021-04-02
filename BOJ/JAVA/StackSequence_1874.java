package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class StackSequence_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        List<Character> sign = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                sign.add('+');
            }

            while (!q.isEmpty() && !stack.isEmpty()) {
                System.out.println(q);
                System.out.println(stack);
                if (!q.peek().equals(stack.peek())) {
                    i++;
                    sign.add('+');
                    stack.push(i);
                } else {
                    stack.pop();
                    q.poll();
                    sign.add('-');
                }
                if (i > n + 1) break;
            }
        }
        if (!stack.isEmpty() && !q.isEmpty()) System.out.println("NO");
        else {
            for (char c : sign)
                System.out.println(c);
        }
    }
}
