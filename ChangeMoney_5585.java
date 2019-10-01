package com.java;

import java.io.*;

public class ChangeMoney_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = 1000;
        int price = Integer.parseInt(br.readLine());

        money -= price;
        int mcnt = 0;
        while (money > 0) {
            if (money / 500 > 0) {
                money -= 500;
                mcnt++;
                continue;
            } else if (money / 100 > 0) {
                money -= 100;
                mcnt++;
                continue;
            } else if (money / 50 > 0) {
                money -= 50;
                mcnt++;
                continue;
            } else if (money / 10 > 0) {
                money -= 10;
                mcnt++;
                continue;
            } else if (money / 5 > 0) {
                money -= 5;
                mcnt++;
                continue;
            } else {
                mcnt += money;
                money = 0;
            }

        }
        bw.append(mcnt + "");
        bw.flush();
    }
}
