package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class PartialSum4_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        long[] in = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sum = new long[n];
        sum[0] = in[0];
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1] + in[i];
        }

        for (int i = 0; i < m; i++) {
            String[] range = br.readLine().split(" ");
            int a = Integer.parseInt(range[0]);
            int b = Integer.parseInt(range[1]);
            if (a > 1)
                System.out.println(sum[b - 1] - sum[a - 2]);
            else
                System.out.println(sum[b - 1]);
        }
    }
}
