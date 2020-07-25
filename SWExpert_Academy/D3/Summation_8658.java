package com.algorithms.SWExpert_Academy.D3;

import java.io.*;
import java.util.Arrays;

public class Summation_8658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");

            int[] u = new int[in.length];
            for (int j = 0; j < in.length; j++) {
                int t = 0;
                char[] tmp = in[j].toCharArray();
                for (int k = 0; k < tmp.length; k++) {
                    t += Integer.parseInt(String.valueOf(tmp[k]));
                }
                u[j] = t;
            }
            Arrays.sort(u);
            bw.append("#" + (i + 1) + " " + u[u.length - 1] + " " + u[0] + "\n");
        }
        bw.flush();

    }
}
