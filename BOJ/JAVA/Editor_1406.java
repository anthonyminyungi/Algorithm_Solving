package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;


// 제한이 0.3초 (300 ms)인데 828ms 인데도 통과된다?
// 모르겠다... 이것보다 더 최적화된 방법은 안떠오른다.
public class Editor_1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        for (char c : arr) {
            stack1.push(c);
        }
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'D':
                    if (!stack2.isEmpty()) stack1.push(stack2.pop());
                    break;
                case 'L':
                    if (!stack1.isEmpty()) stack2.push(stack1.pop());
                    break;
                case 'P':
                    char add = st.nextToken().charAt(0);
                    stack1.push(add);
                    break;
                case 'B':
                    if (!stack1.isEmpty()) stack1.pop();
                    break;
            }
        }
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        while (!stack2.isEmpty()) sb.append(stack2.pop());
        System.out.println(sb);
    }
}
