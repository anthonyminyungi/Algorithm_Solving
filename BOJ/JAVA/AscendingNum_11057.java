package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedHashMap;

public class AscendingNum_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedHashMap<Integer, BigInteger> hashMap = new LinkedHashMap<>();
        hashMap.put(1, BigInteger.valueOf(10));
        hashMap.put(2, BigInteger.valueOf(55));
        hashMap.put(3, BigInteger.valueOf(220));
        hashMap.put(4, BigInteger.valueOf(715));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] temp = {BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5), BigInteger.valueOf(6), BigInteger.valueOf(7), BigInteger.valueOf(8), BigInteger.valueOf(9), BigInteger.valueOf(10)};
        BigInteger sum = BigInteger.ZERO;
        if (hashMap.containsKey(n)) {
            bw.append((hashMap.get(n)) + "\n");
        } else {
            for (int j = 1; j < n - 1; j++) {
                for (int k = 1; k < 10; k++) {
                    temp[k] = temp[k].add(temp[k - 1]);
                }
            }
            for (int j = 0; j < 10; j++) {
                sum = sum.add(temp[j]);
            }

            sum = sum.mod(BigInteger.valueOf(10007));
            hashMap.put(n, sum);
            bw.append((sum) + "\n");
        }

        bw.flush();
    }
}
