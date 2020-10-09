package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class FactorizationToPrime_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (N != 1) {
            for (int i = 2; i <= N; i++) {
                if (N % i == 0) {
                    N /= i;
                    list.add(i);
                    break;
                }
            }
        }
        Collections.sort(list);
        for (int k : list) {
            System.out.println(k);
        }
    }
}
