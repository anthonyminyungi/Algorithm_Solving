package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ExamScore_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int T = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println(Math.max(S, T));
    }
}

