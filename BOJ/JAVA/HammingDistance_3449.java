package com.java.BOJ.JAVA;

import java.io.*;

public class HammingDistance_3449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            String k = br.readLine();
            String p = br.readLine();
            for (int j = 0; j < k.length(); j++) {
                if (k.charAt(j) != p.charAt(j))
                    cnt++;
            }
            bw.append("Hamming distance is " + cnt + ".\n");
        }
        bw.flush();
    }

}
