package com.algorithms.BOJ.JAVA;

import java.io.*;

public class SelectingQuadrant_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if (x >= 0 && y >= 0) {
            answer = 1;
        } else if (x < 0 && y >= 0) {
            answer = 2;
        } else if (x < 0) {
            answer = 3;
        } else {
            answer = 4;
        }
        System.out.println(answer);
    }
}
