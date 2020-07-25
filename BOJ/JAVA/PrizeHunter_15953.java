package com.algorithms.BOJ.JAVA;

import java.io.*;

//카카오
public class PrizeHunter_15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] A = {0, 500, 300, 300, 200, 200, 200, 50, 50, 50, 50, 30, 30, 30, 30, 30, 10, 10, 10, 10, 10, 10};
        int[] B = {0, 512, 256, 256, 128, 128, 128, 128, 64, 64, 64, 64, 64, 64, 64, 64, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

        for (int i = 0; i < T; i++) {
            int sum = 0;
            String[] a = br.readLine().split(" ");

            if ((Integer.parseInt(a[0]) >= 0 && Integer.parseInt(a[0]) < 22))
                sum += A[Integer.parseInt(a[0])] * 10000;
            else
                sum += 0;
            if (Integer.parseInt(a[1]) >= 0 && Integer.parseInt(a[1]) < 32)
                sum += B[Integer.parseInt(a[1])] * 10000;
            else
                sum += 0;
            bw.append(sum + "\n");
        }
        bw.flush();
    }
}
