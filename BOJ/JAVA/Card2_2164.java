package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Card2_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }
        int i = 1;
        while (deque.size() > 1) {
            if (i % 2 == 0) {
                deque.addLast(deque.removeFirst());
            } else {
                deque.removeFirst();
            }
            i++;
        }
        System.out.println(deque.getFirst());
    }
}
