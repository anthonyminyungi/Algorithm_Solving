package com.java.BOJ.JAVA;

import java.io.*;

// dp...
public class ContinuousSum_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int gmax = 0;
        for (int i = 0; i < N; i++) {
            int sum = Integer.parseInt(in[i]);
            int max = sum;
            for (int j = i + 1; j < N; j++) {
                sum += Integer.parseInt(in[j]);
                max = Math.max(max, sum);
            }
            System.out.println(max);
            if (i == 0)
                gmax = max;
            else
                gmax = Math.max(gmax, max);
        }
        System.out.println(gmax);
    }
}
