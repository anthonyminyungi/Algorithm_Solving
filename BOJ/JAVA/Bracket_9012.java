package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Stack;

public class Bracket_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String b = br.readLine();
            Stack<String> stack = new Stack<>();
            stack.push(String.valueOf(b.charAt(0)));
            for (int j = 1; j < b.length(); j++) {
                String k = String.valueOf(b.charAt(j));
                if (!stack.isEmpty() && stack.peek().equals("(") && k.equals(")"))
                    stack.pop();
                else
                    stack.push(k);
            }
            if (stack.isEmpty())
                bw.append("YES\n");
            else
                bw.append("NO\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
