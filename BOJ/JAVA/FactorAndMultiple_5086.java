package com.algorithms.BOJ.JAVA;

import java.io.*;

public class FactorAndMultiple_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String in = "";
        while (!(in = br.readLine()).equals("0 0")) {
            String[] s = in.split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);
            if (second % first == 0) bw.append("factor").append("\n");
            else if (first % second == 0) bw.append("multiple").append("\n");
            else bw.append("neither").append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
