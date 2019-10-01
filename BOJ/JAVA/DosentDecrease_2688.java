package com.java.BOJ.JAVA;

import java.io.*;
import java.util.LinkedHashMap;

public class DosentDecrease_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        LinkedHashMap<Integer, Long> hashMap = new LinkedHashMap<>();
        hashMap.put(1, (long) 10);
        hashMap.put(2, (long) 55);
        hashMap.put(3, (long) 220);
        hashMap.put(4, (long) 715);
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            long sum = 0;
            if (hashMap.containsKey(n)) {
                bw.append(hashMap.get(n) + "\n");
            } else {

                for (int j = 1; j < n - 1; j++) {
                    for (int k = 1; k < 10; k++) {
                        temp[k] = temp[k] + temp[k - 1];
                    }
                }
                for (int j = 0; j < 10; j++) {
                    sum += temp[j];
                }
                hashMap.put(n, sum);
                bw.append(sum + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
