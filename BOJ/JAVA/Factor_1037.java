package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Factor_1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] factors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (k == 1) {
            System.out.println(factors[0] * factors[0]);
        } else {
            Arrays.sort(factors);
            System.out.println(factors[0] * factors[k - 1]);
        }
    }
}
