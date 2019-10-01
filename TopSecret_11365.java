package com.java;

import java.io.*;

public class TopSecret_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String a = br.readLine();
            if (a.equals("END"))
                break;
            for (int i = a.length() - 1; i >= 0; i--) {
                bw.append(a.charAt(i));
            }
            bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
