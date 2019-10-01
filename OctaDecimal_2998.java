package com.java;

import java.io.*;

public class OctaDecimal_2998 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] e = {"000", "001", "010", "011", "100", "101", "110", "111"};
        StringBuilder k = new StringBuilder(br.readLine());
        while (true) {
            if (k.length() % 3 == 0)
                break;
            k.insert(0, "0");

        }
        for (int i = 0; i < k.length(); i += 3) {
            String sub = k.substring(i, i + 3);
            for (int j = 0; j < e.length; j++) {
                if (sub.equals(e[j])) {
                    bw.append(j + "");
                    break;
                }
            }
        }
        bw.flush();
    }
}
