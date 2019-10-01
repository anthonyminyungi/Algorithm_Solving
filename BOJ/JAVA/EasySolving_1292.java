package com.java.BOJ.JAVA;

import java.io.*;

public class EasySolving_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1001];
        int index = 0;

        for (int i = 1; i <= 45; i++) {

            for (int j = 0; j < i; j++) {
                if (index >= 1001)
                    break;
                arr[index] = i;
                index++;
            }
        }
        String[] a = br.readLine().split(" ");
        int A = Integer.parseInt(a[0]);
        int B = Integer.parseInt(a[1]);
        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += arr[i];
        }
        bw.append(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
