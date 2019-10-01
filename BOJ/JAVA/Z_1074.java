package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z_1074 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int c = Integer.parseInt(in[1]);
        int r = Integer.parseInt(in[2]);

        int solution = 0;
        int devide = (int) Math.pow(2, N - 1);
        int mul = (int) Math.pow(4, N - 1);


        for (int i = 0; i < N; i++) {
            solution += ((c / devide) * mul) * 2 + ((r / devide) * mul);
            r %= devide;
            c %= devide;
            devide /= 2;
            mul /= 4;
        }

        System.out.println(solution);
    }
}
