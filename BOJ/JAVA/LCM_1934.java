package com.algorithms.BOJ.JAVA;

import java.io.*;

public class LCM_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int gcd = gcd(a, b);
            int lcm = (a * b) / gcd;
            bw.append(String.valueOf(lcm)).append("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int gcd(int a, int b) {
        int i, j;
        int temp = 1;
        j = Math.min(a, b);

        for (i = 1; i <= j; i++) {
            if (a % i == 0 && b % i == 0)
                temp = i;
        }
        return temp;
    }
}
