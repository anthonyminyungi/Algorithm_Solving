package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Stack;

public class SteelPipe_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        bw.append(solution(a) + "");
        bw.flush();
    }

    public static int solution(String arrangement) {
        int answer = 0;
        char[] arr = arrangement.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                stack.pop();
                if (arr[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
