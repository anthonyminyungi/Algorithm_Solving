package com.java.BOJ.JAVA;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            int currentTop = stack.peek();
            while (!stack.isEmpty() && arr[currentTop] < arr[i]) {
                result[stack.pop()] = i + 1;
            }
            stack.push(i);
        }

        /*
         *  무자비한 시간초과와 메모리초과에 못이겨 정답 코드를 서치함.
         *  반성을 위해 내가 직접 구현했던 코드 남겨둠.
         *  현자타임...
         */
//        int k = N - 1;
//        int idx = N - 1;
//        int tmp = 0;
//        boolean isFail = false;
//        while (!stack.isEmpty()) {
//            if (!isFail) {
//                tmp = stack.pop();
//            }
//            if (!stack.isEmpty() && stack.peek() >= tmp) {
//                arr[idx] = k;
//                while (!stack1.isEmpty()) {
//                    stack.push(stack1.pop());
//                    k++;
//                }
//                idx--;
//                isFail = false;
//            } else {
//                isFail = true;
//                if (!stack.isEmpty())
//                    stack1.push(stack.pop());
//            }
//            if (stack.isEmpty()) {
//                arr[idx] = 0;
//                idx--;
//                k--;
//                isFail = false;
//                while (!stack1.isEmpty()) {
//                    stack.push(stack1.pop());
//                    k++;
//                }
//            }
//            k--;
//        }
        for (int i = 0; i < N; i++) {
            bw.append(String.valueOf(result[i])).append(" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
