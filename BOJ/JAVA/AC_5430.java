package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class AC_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] functions = br.readLine().toCharArray();
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();
            s = s.substring(1, s.length() - 1);
            int[] arr = len == 0 ? new int[0] : Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();

            Deque<Integer> deque = new LinkedList<>();
            for (int a : arr) deque.offer(a);
            boolean reverse = false, error = false;
            for (char f : functions) {
                if (f == 'R') reverse = !reverse;
                else {
                    if (deque.isEmpty()) {
                        bw.append("error").append("\n");
                        error = true;
                        break;
                    } else {
                        if (reverse) deque.pollLast();
                        else deque.pollFirst();
                    }
                }
            }
            if (!error) {
                bw.append("[");
                while (!deque.isEmpty()) {
                    bw.append(String.valueOf(reverse ? deque.pollLast() : deque.pollFirst()));
                    if (!deque.isEmpty()) bw.append(",");
                }
                bw.append("]").append("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
