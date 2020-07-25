package com.algorithms.BOJ.JAVA;

import java.io.*;
import java.util.Arrays;

public class SubjectChoice_11948 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sci = new int[4];
        int[] mo = new int[2];

        for (int i = 0; i < 4; i++) {
            sci[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 2; i++) {
            mo[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sci);
        Arrays.sort(mo);
        System.out.println(sci[1] + sci[2] + sci[3] + mo[1]);
    }
}
