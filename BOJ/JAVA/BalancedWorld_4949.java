package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class BalancedWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = "";
        Stack<Character> stack = new Stack<>();
        while (!(in = br.readLine()).equals(".")) {
            boolean flag = true;
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) == '(' || in.charAt(i) == '[')
                    stack.push(in.charAt(i));
                if (in.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (in.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                if (!flag)
                    bw.append("no\n");
                else
                    bw.append("yes\n");
            } else
                bw.append("no\n");
            stack.clear();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
