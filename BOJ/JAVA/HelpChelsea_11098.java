package com.java.BOJ.JAVA;

import java.io.*;

public class HelpChelsea_11098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            String expensive = "";
            int max = 0;
            for (int j = 0; j < p; j++) {
                String[] a = br.readLine().split(" ");
                if (Integer.parseInt(a[0]) > max) {
                    max = Integer.parseInt(a[0]);
                    expensive = a[1];
                }

            }
            bw.append(expensive + "\n");
        }
        bw.flush();
    }

}
