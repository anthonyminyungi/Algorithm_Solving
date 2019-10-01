package com.java;

import java.io.*;

public class Receipt_5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine());
        int temp = 0;
        for (int i = 0; i < 9; i++) {
            int book = Integer.parseInt(br.readLine());
            temp += book;
        }
        bw.append((total - temp) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
