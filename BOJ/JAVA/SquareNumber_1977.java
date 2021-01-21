package com.algorithms.BOJ.JAVA;

import java.io.*;

public class SquareNumber_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = m; i <= n; i++) {
            if (String.valueOf(Math.sqrt(i)).split("\\.")[1].length() == 1) {
                sum += i;
                min = Math.min(min, i);
                cnt++;
            }
        }
        if (cnt == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
