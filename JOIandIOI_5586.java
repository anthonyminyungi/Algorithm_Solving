package com.java;

import java.io.*;

public class JOIandIOI_5586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String joi = "JOI";
        int jcnt = 0;
        String ioi = "IOI";
        int icnt = 0;
        String in = br.readLine();
        for (int i = 0; i < in.length() - 2; i++) {
            String temp = in.substring(i, i + 3);
            if (temp.equals(joi))
                jcnt++;
            if (temp.equals(ioi))
                icnt++;
        }
        bw.append(jcnt + "\n" + icnt + "");
        bw.flush();
    }

}
