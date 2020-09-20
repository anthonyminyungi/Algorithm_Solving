package com.algorithms.BOJ.JAVA;


import java.io.*;
import java.util.*;

public class StringSet_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int answer = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine()))
                answer++;
        }
        System.out.println(answer);
    }
}
