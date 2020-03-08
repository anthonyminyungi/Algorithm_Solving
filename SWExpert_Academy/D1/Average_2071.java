package com.java.SWExpert_Academy.D1;

import java.io.*;

public class Average_2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] in = br.readLine().split(" ");
            int sum = 0;
            for (int j = 0; j < in.length; j++) {
                sum += Integer.parseInt(in[j]);
            }
            bw.append("#").append(String.valueOf(i)).append(" ").append(String.valueOf(Math.round((float) sum / in.length))).append("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
