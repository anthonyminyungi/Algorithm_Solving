package com.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
이해 필요
 */
public class Multiply_1629 {
    static long pow(long a, long b, long c) {
        long ret = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                ret = ret * a;
                ret %= c;
            }
            a *= (a % c);
            a %= c;
            b /= 2;
        }

        return ret % c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b, c));
    }
}