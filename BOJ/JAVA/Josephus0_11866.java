package com.java.BOJ.JAVA;

import java.io.*;
import java.util.ArrayList;

public class Josephus0_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);
        int tmp = 0;

        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> josepus = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        while (!arr.isEmpty()) {
            tmp = (tmp + K - 1) % arr.size();
            josepus.add(arr.remove(tmp));
        }
        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(josepus.get(i));

            if (i != N - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
