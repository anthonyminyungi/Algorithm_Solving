package com.algorithms.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> list = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            String number = br.readLine();
            if (number.equals("0")) {
                list.removeLast();
            } else {
                list.addLast(Integer.parseInt(number));
            }
        }
        int sum = 0;
        while (!list.isEmpty()) {
            sum += list.removeFirst();
        }
        System.out.println(sum);
    }
}
