package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

// 자바 시간제한이 너무 빡세게 걸려있어 I/O 때문에 14번제출만에 통과
public class FindingMinimum_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] fl = br.readLine().split(" ");
        int n = Integer.parseInt(fl[0]);
        int l = Integer.parseInt(fl[1]);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] in = new int[n];

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && in[deque.getLast()] > in[i]) {
                deque.removeLast();
            }

            if (!deque.isEmpty() && deque.getFirst() < i - l + 1)
                deque.removeFirst();

            deque.offer(i);

            if (!deque.isEmpty())
                sb.append(in[deque.getFirst()]).append(' ');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
