package com.java;

import java.io.*;

public class ReversedAdding_1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        sb.append(a[0]);
        int revx = Integer.parseInt(String.valueOf(sb.reverse()));
        sb = new StringBuffer();
        sb.append(a[1]);
        int revy = Integer.parseInt(String.valueOf(sb.reverse()));
        sb = new StringBuffer();
        sb.append(revx + revy);
        int revsum = Integer.parseInt(String.valueOf(sb.reverse()));
        System.out.println(revsum);
    }
}
