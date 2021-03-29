package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class CalculateScore_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int score = 1;
        int total = 0;

        for (int j : scores) {
            if (j == 1) total += score++;
            else score = 1;
        }
        System.out.println(total);
    }
}
