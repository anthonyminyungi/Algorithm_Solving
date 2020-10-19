package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class SumOfNumbers2_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int s = 0, e = 0;
        int sum = 0, res = 0;
        while (true) {
            if (sum >= m)
                sum -= arr[s++];
            else if (e > n - 1)
                break;
            else
                sum += arr[e++];
            if (sum == m)
                res++;
        }

        System.out.println(res);
    }
}
