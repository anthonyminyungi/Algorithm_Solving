package com.algorithms.BOJ.JAVA;

import java.io.*;

public class IamCook_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxindex = 0;
        int max = 0;
        for (int i = 1; i <= 5; i++) {
            String[] a = br.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(a[j]);
            }
            if (sum > max) {
                maxindex = i;
                max = sum;
            }
        }
        bw.write(maxindex + " " + max);
        bw.flush();
    }
}
