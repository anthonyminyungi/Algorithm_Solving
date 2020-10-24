package com.algorithms.Goorm.NHNPreTest;

import java.io.*;
import java.util.*;

// 주문표 변환하기
public class Solution3 {
    public static void main(String[] args) throws IOException {
        solution(2, new String[]{"B2(RG)", "3(R2(GB))"});
        solution(3, new String[]{"3(BR2(R))", "B(RGB(RG))", "1B2R3G"});
        solution(5, new String[]{"3(R2(GB))", "1(R)2(G)B", "2(R3G)", "2(B(1(R)2(G2B)))", "2(B(R)2(G))1(B2(B(R)))"});
    }

    private static void solution(int numOfOrder, String[] orderArr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < numOfOrder; i++) {
            String currentOrder = orderArr[i];
            stack.push(currentOrder.charAt(0));
            for (int j = 1; j < currentOrder.length(); j++) {
                if (Character.isLetter(currentOrder.charAt(j))) {
                    if (Character.isDigit(stack.peek())) {
                        int c = Integer.parseInt(String.valueOf(stack.pop()));
                        for (int t = 0; t < c; t++) {
                            stack.push(currentOrder.charAt(j));
                        }
                    } else stack.push(currentOrder.charAt(j));
                } else if (currentOrder.charAt(j) == ')') {
                    String tmp = "";
                    while (stack.peek() != '(') {
                        tmp = stack.pop() + tmp;
                    }
                    stack.pop(); // pop '('
                    if (Character.isDigit(stack.peek())) {
                        int c = Integer.parseInt(String.valueOf(stack.pop()));
                        for (int t = 0; t < c; t++) {
                            for (int k = 0; k < tmp.length(); k++) {
                                stack.push(tmp.charAt(k));
                            }
                        }
                    } else {
                        char c = stack.pop();
                        for (int k = 0; k < tmp.length(); k++) {
                            stack.push(c);
                            stack.push(tmp.charAt(k));
                        }
                    }
                } else
                    stack.push(currentOrder.charAt(j));
            }
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            bw.write(sb.toString() + "\n");
            bw.flush();
            sb.setLength(0);
        }
    }
}
