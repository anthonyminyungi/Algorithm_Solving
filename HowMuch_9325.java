package com.java;

import java.io.*;

public class HowMuch_9325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int price = 0;
            int s = Integer.parseInt(br.readLine());
            price += s;
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                for (int j = 0; j < n; j++) {
                    String[] option = br.readLine().split(" ");
                    int opnum = Integer.parseInt(option[0]);
                    int opprice = Integer.parseInt(option[1]);
                    price += opnum * opprice;
                }
            }
            bw.append(price + "\n");

        }
        bw.flush();
    }
}
