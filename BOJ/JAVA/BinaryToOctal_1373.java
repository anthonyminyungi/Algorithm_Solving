package com.algorithms.BOJ.JAVA;

import java.io.*;

public class BinaryToOctal_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = br.readLine();
        StringBuilder sb = new StringBuilder();
        int initIdx = 0;
        if (binary.length() % 3 == 1) {
            initIdx += 1;
        } else if (binary.length() % 3 == 2) {
            initIdx += 2;
        } else {
            initIdx += 3;
        }
        sb.append(binToOct(binary.substring(0, initIdx)));

        for (int i = initIdx + 3; i <= binary.length(); i += 3) {
            sb.append(binToOct(binary.substring(initIdx, i)));
            initIdx = i;
        }
        System.out.println(sb.toString());
    }

    private static String binToOct(String bin) {
        if (bin.equals("1") || bin.equals("001")) {
            return "1";
        } else if (bin.equals("10") || bin.equals("010")) {
            return "2";
        } else if (bin.equals("11") || bin.equals("011")) {
            return "3";
        } else if (bin.equals("100")) {
            return "4";
        } else if (bin.equals("101")) {
            return "5";
        } else if (bin.equals("110")) {
            return "6";
        } else if (bin.equals("111")) {
            return "7";
        } else {
            return "0";
        }
    }
}
