package com.java;

import java.io.*;

public class SangeunNald_5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sang = Integer.parseInt(br.readLine());
        int joong = Integer.parseInt(br.readLine());
        int Ha = Integer.parseInt(br.readLine());
        int Cola = Integer.parseInt(br.readLine());
        int Sider = Integer.parseInt(br.readLine());

        int burger = Math.min(sang, joong);
        burger = Math.min(burger, Ha);

        int gl = Math.min(Cola, Sider);

        System.out.println(burger + gl - 50);
    }
}
