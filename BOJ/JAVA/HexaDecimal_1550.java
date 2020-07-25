package com.algorithms.BOJ.JAVA;

import java.io.*;

public class HexaDecimal_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String hex = br.readLine();
        int dec = 0;
        int reverseindex = 0;
        for (int i = hex.length() - 1; i >= 0; i--) {
            dec += HexToDec(hex.charAt(i)) * Math.pow(16, reverseindex);
            reverseindex++;
        }
        bw.append(dec + "");
        bw.flush();
    }

    static int HexToDec(char c) {
        int res;
        if (c == 'A') {
            res = 10;
        } else if (c == 'B') {
            res = 11;
        } else if (c == 'C') {
            res = 12;
        } else if (c == 'D') {
            res = 13;
        } else if (c == 'E') {
            res = 14;
        } else if (c == 'F') {
            res = 15;
        } else {
            res = Integer.parseInt(String.valueOf(c));
        }
        return res;
    }
}
