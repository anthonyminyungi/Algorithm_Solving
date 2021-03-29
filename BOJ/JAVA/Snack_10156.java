package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class Snack_10156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = in[0] * in[1] - in[2];
        System.out.println(Math.max(ans, 0));
    }
}
