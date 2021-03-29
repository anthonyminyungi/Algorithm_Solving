package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Ah_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String can = br.readLine();
        String required = br.readLine();

        System.out.println(can.length() >= required.length() ? "go" : "no");
    }
}
