package com.java.BOJ.JAVA;

import java.io.*;

public class BinaryNumber_3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int toBi = Integer.parseInt(br.readLine());

            char[] Bi = Integer.toBinaryString(toBi).toCharArray();
            int reverseIndex = 0;
            for (int j = Bi.length - 1; j >= 0; j--) {
                if (Bi[j] == '1') {
                    if (j != 0)
                        bw.append(reverseIndex + " ");
                    else
                        bw.append(reverseIndex + "");
                }
                reverseIndex++;
            }
            bw.append("\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }


}
