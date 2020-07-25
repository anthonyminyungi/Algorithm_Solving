package com.algorithms.BOJ.JAVA;

import java.io.*;

public class CoinGame_2684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] triple = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};

        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            String a = br.readLine();
            int[] tirplecnt = new int[8];
            for (int j = 0; j < 38; j++) {
                int begin = j;
                int end = begin + 3;
                String e = a.substring(begin, end);
//                System.out.println(e);
                for (int k = 0; k < 8; k++) {
                    if (triple[k].equals(e))
                        tirplecnt[k] += 1;
                }
            }
            for (int l = 0; l < 8; l++) {
                bw.append(tirplecnt[l] + " ");
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
