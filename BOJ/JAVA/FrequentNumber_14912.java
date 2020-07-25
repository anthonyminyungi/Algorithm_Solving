package com.algorithms.BOJ.JAVA;

import java.io.*;

public class FrequentNumber_14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]);
        int toFind = Integer.parseInt(in[1]);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
        }
        char[] chars = sb.toString().toCharArray();
        for (char aChar : chars) {
            if (Integer.parseInt(String.valueOf(aChar)) == toFind)
                cnt++;
        }
        System.out.println(cnt);
    }
}
