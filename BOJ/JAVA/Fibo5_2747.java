package com.java.BOJ.JAVA;

import java.io.*;

public class Fibo5_2747 {//2748,10870

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] fibo = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597};
        long[] real = new long[91];
        System.arraycopy(fibo, 0, real, 0, 18);
        for (int i = 18; i < 91; i++) {
            real[i] = real[i - 1] + real[i - 2];
        }
        int n = Integer.parseInt(br.readLine());
        bw.append(real[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
/**
 * public class Fibo5_2747 {//2748,10870
 * <p>
 * public static void main(String[] args) throws IOException {
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 * BigInteger[] fibo = {BigInteger.valueOf(0), BigInteger.valueOf(1), BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5), BigInteger.valueOf(8), BigInteger.valueOf(13), BigInteger.valueOf(21), BigInteger.valueOf(34), BigInteger.valueOf(55), BigInteger.valueOf(89), BigInteger.valueOf(144), BigInteger.valueOf(233), BigInteger.valueOf(377), BigInteger.valueOf(610), BigInteger.valueOf(987), BigInteger.valueOf(1597)};
 * BigInteger[] real = new BigInteger[10001];
 * System.arraycopy(fibo, 0, real, 0, 18);
 * for (int i = 18; i < 10001; i++) {
 * real[i] = real[i - 1].add(real[i - 2]);
 * //            System.out.println(real[i]);
 * }
 * int n = Integer.parseInt(br.readLine());
 * bw.append(real[n] + "");
 * bw.flush();
 * bw.close();
 * br.close();
 * }
 * }
 */