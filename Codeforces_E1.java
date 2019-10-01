package com.java;

import java.io.*;

public class Codeforces_E1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());

        String temp = "";
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= i; j++) {
                temp += j;

            }
        }
//        System.out.println(temp);

        for (int i = 0; i < q; i++) {
            int qi = Integer.parseInt(br.readLine());
            bw.append(temp.charAt(qi - 1) + "\n");

        }
        bw.flush();


    }

}
