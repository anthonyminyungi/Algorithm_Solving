package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 연산자 우선순위를 신경써야 하는 부분이 난해했다.
// 풀이 참고 (코드x) : https://emgc.tistory.com/22
public class PostFix_1918 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char cur = exp.charAt(i);
            if (Character.isLetter(cur)) answer.append(cur);
            else {
                if (cur == '*' || cur == '/') {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        answer.append(stack.pop());
                    }
                    stack.push(cur);
                } else if (cur == '+' || cur == '-') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        answer.append(stack.pop());
                    }
                    stack.push(cur);
                } else if (cur == '(') {
                    stack.push(cur);
                } else if (cur == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        answer.append(stack.pop());
                    }
                    if (!stack.isEmpty()) stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) answer.append(stack.pop());
        //(A+(B*C))-(D/E)
        System.out.println(answer);
    }
}
