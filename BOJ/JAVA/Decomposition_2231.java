package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Decomposition_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        int n = Integer.parseInt(in);
        int tmp = n;
        if (tmp > 9) tmp -= in.length() * 9;
        if (tmp < 0) tmp = 0;

        boolean have = false;
        int answer = 0;
        for (int i = tmp; i < n; i++) {
            int sum = i;
            String traversal = String.valueOf(i);
            for (int j = 0; j < traversal.length(); j++) {
                sum += Integer.parseInt(String.valueOf(traversal.charAt(j)));
            }
            if (sum == n) {
                have = true;
                answer = i;
                break;
            }
        }

        if (!have) answer = 0;

        System.out.println(answer);
    }
}
