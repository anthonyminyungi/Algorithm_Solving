package com.java.BOJ.JAVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hangseung_1449 {

    public static void main(String[] args) throws IOException {
        // write your code here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int numofLeak = Integer.parseInt(input[0]);
        int tapelength = Integer.parseInt(input[1]);
        int[] leakPoint = new int[numofLeak];
        for (int i = 2; i < numofLeak; i++) {
            leakPoint[i - 2] = Integer.parseInt(input[i]);
        }


    }
}
