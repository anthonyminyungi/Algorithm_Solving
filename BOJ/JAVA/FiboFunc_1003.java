package com.java.BOJ.JAVA;

import java.io.*;

public class FiboFunc_1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        zero[1] = 0;
        zero[2] = 1;
        zero[3] = 1;
        one[0] = 0;
        one[1] = 1;
        one[2] = 1;
        one[3] = 2;
        int T = Integer.parseInt(br.readLine());
        for (int i = 4; i < 41; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(zero[n] + " " + one[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
