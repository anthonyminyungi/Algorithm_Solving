package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.*;

public class ExamInvigilator_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        String[] bc = br.readLine().split(" ");
        int b = Integer.parseInt(bc[0]);
        int c = Integer.parseInt(bc[1]);

        long total = 0;
        for (int i = 0; i < n; i++) {
            long cur = a[i];
            if (cur - b < 0) cur = 0;
            else cur -= b;

            total++;
            if (cur % c == 0) total += cur / c;
            else total += cur / c + 1;

        }
        System.out.println(total);
    }
}
