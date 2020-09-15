package com.algorithms.BOJ.JAVA;

import java.io.*;

public class Set_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int S = 1 << 20;

        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            if (in.equals("all")) {
                S = -1 >>> 11;
            } else if (in.equals("empty")) {
                S = 1 << 20;
            } else {
                String[] sp = in.split(" ");
                switch (sp[0]) {
                    case "add":
                        if (Integer.toBinaryString(S).charAt(Integer.toBinaryString(S).length() - 1 - (Integer.parseInt(sp[1]) - 1)) != '1') {
                            S = S | (1 << (Integer.parseInt(sp[1]) - 1));
                        }
                        break;
                    case "remove":
                        if (Integer.toBinaryString(S).charAt(Integer.toBinaryString(S).length() - 1 - (Integer.parseInt(sp[1]) - 1)) == '1') {
                            S = S & ~(1 << (Integer.parseInt(sp[1]) - 1));
                        }
                        break;
                    case "toggle":
                        if (Integer.toBinaryString(S).charAt(Integer.toBinaryString(S).length() - 1 - (Integer.parseInt(sp[1]) - 1)) == '1') {
                            S = S & ~(1 << (Integer.parseInt(sp[1]) - 1));
                        } else {
                            S = S | (1 << (Integer.parseInt(sp[1]) - 1));
                        }
                        break;
                    default:
                        if (Integer.toBinaryString(S).charAt(Integer.toBinaryString(S).length() - 1 - (Integer.parseInt(sp[1]) - 1)) == '1') {
                            bw.append("1\n");
                        } else {
                            bw.append("0\n");
                        }
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
